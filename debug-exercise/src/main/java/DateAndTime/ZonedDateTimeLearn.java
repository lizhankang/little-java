package DateAndTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeLearn {

    public static void main(String[] args) {
//        specifyZone();
//        localDateTimePlusZone();
        zoneTransform();
    }


    /*
    指定时区创建ZonedDateTime
     */
    public static void specifyZone() {
        // 默认时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        // 用指定时区获取当前时间
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime1);
    }


    public static void localDateTimePlusZone() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime);
    }

    /*
    时区转换：在另一个时区 此时刻 的 时间
     */
    public static void zoneTransform() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
    }
}
