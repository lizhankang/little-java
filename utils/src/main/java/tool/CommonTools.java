package tool;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Random;
import java.util.UUID;
import java.security.SecureRandom;

public class CommonTools {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
//        System.out.println(getDateTime());
        System.out.println(generateUniqueNumber(18));
    }

    // 当前时间
    public static String getDateTime() {
        // 获取当前时间，并设置为东八区
        ZonedDateTime currentDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        return currentDateTime.format(formatter);
    }

    // 随机数
    // 生成指定长度的唯一数字字符串
    public static String generateUniqueNumber(int length) {
        // 获取当前时间的毫秒级时间戳
        long currentTimeMillis = System.currentTimeMillis();

        // 将时间戳转换为字符串
        String timePart = String.valueOf(currentTimeMillis);

        // 生成一个随机的数字部分以补充到指定长度
        Random random = new Random();
        StringBuilder randomPart = new StringBuilder();

        // 生成随机数字串（补全到指定长度）
        int remainingLength = length - timePart.length();
        for (int i = 0; i < remainingLength; i++) {
            randomPart.append(random.nextInt(10)); // 生成0-9之间的随机数字
        }

        // 组合时间戳部分和随机部分
        String result = timePart + randomPart.toString();

        // 如果组合的长度超过指定长度，则截取
        if (result.length() > length) {
            result = result.substring(0, length);
        }

        return result;
    }

}
