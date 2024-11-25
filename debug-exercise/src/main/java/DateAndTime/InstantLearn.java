package DateAndTime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Java提供的System.currentTimeMillis()返回的就是以毫秒表示的当前时间戳。
 * 这个当前时间戳在java.time中以Instant类型表示，
 * 我们用Instant.now()获取当前时间戳，效果和System.currentTimeMillis()类似
 */
public class InstantLearn {
    public static void main(String[] args) {
//        getCurrentTimeTamp();
        instantToZonedDateTime();
    }

    public static void getCurrentTimeTamp() {
        Instant now = Instant.now();
        System.out.println(System.currentTimeMillis());
        System.out.println(now.getEpochSecond()); // 秒
        System.out.println(now.toEpochMilli()); // 毫秒
    }

    public static void instantToZonedDateTime() {
        Instant ins = Instant.ofEpochSecond(1568568760);
        ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
        System.out.println(zdt); // 2019-09-16T01:32:40+08:00[Asia/Shanghai]
    }
}
