package tool;

public class SnowflakeIdGenerator {
    // 定义时间戳偏移量
    private static final long EPOCH = 1609459200000L; // 起始时间戳 (2021-01-01)

    // 每个部分的位数
    private static final long WORKER_ID_BITS = 5L;
    private static final long DATACENTER_ID_BITS = 5L;
    private static final long SEQUENCE_BITS = 12L;

    // 最大值计算
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS); // 31
    private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BITS); // 31
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS); // 4095

    // 位移操作
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;
    private static final String BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int BASE = BASE62.length();;

    private final long workerId; // 工作机器ID (0~31)
    private final long datacenterId; // 数据中心ID (0~31)
    private long sequence = 0L; // 序列号
    private long lastTimestamp = -1L; // 上一次生成ID的时间戳

    public SnowflakeIdGenerator(long workerId, long datacenterId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format("workerId can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenterId can't be greater than %d or less than 0", MAX_DATACENTER_ID));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    // 生成唯一ID
    public synchronized long nextId() {
        long timestamp = timeGen();

        // 如果当前时间小于上次生成ID的时间戳，说明时钟回退过，这时抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
        }

        // 如果是同一毫秒内生成的ID，则自增序列号
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            // 序列号超出范围时等待下一毫秒
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            // 不在同一毫秒内，重置序列号
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        // 通过位运算生成ID
        return ((timestamp - EPOCH) << TIMESTAMP_LEFT_SHIFT)
                | (datacenterId << DATACENTER_ID_SHIFT)
                | (workerId << WORKER_ID_SHIFT)
                | sequence;
    }

    // 等待下一毫秒的时间戳
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    // 获取当前时间戳
    private long timeGen() {
        return System.currentTimeMillis();
    }

    // 将生成的ID转换为字符串
    public String generateUniqueString() {
        return Long.toString(nextId());
    }
    // 将生成的ID转换为指定长度的唯一字符串 (62进制编码)
    public String generateUniqueString(int length) {
        long id = nextId();
        String base62Id = toBase62(id);

        // 如果生成的ID小于指定长度，使用随机填充或其他逻辑补全
        if (base62Id.length() > length) {
            return base62Id.substring(0, length);
        } else if (base62Id.length() < length) {
            return String.format("%1$" + length + "s", base62Id).replace(' ', '0'); // 用0填充
        }
        return base62Id;
    }

    // 将ID转换为62进制字符串
    private String toBase62(long id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(BASE62.charAt((int) (id % BASE)));
            id /= BASE;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        // 实例化雪花ID生成器 (指定workerId和datacenterId)
        SnowflakeIdGenerator generator = new SnowflakeIdGenerator(1, 1);

        // 生成唯一字符串
        String uniqueId = generator.generateUniqueString();
        String uniqueId2 = generator.generateUniqueString(10);
        System.out.println(uniqueId);
        System.out.println(uniqueId2);
    }
}

