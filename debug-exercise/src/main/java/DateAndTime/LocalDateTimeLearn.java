package DateAndTime;

import java.time.*;

public class LocalDateTimeLearn {
    public static void main(String[] args) {
//       getNow();
//        fromLocalDateTimeToLocalDateAndLocalTime();
//        fromSpecifiedDateTimeToLocalDateTimeByOf();
        convertISO8601StringToLocalDateTime();
    }

    public static void getNow() {
        LocalDate d = LocalDate.now(); // 当前日期
        LocalTime t = LocalTime.now(); // 当前时间
        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印
        /*
        注意 ISO 8601 规定的日期和时间分隔符是T。标准格式如下：
            日期：yyyy-MM-dd
            时间：HH:mm:ss
            带毫秒的时间：HH:mm:ss.SSS
            日期和时间：yyyy-MM-dd'T'HH:mm:ss
            带毫秒的日期和时间：yyyy-MM-dd'T'HH:mm:ss.SSS
         */
    }

    public static void fromLocalDateTimeToLocalDateAndLocalTime() {
        LocalDateTime dt = LocalDateTime.now();
        LocalDate d = dt.toLocalDate();
        LocalTime t = dt.toLocalTime();
        System.out.println(dt);
        System.out.println(d);
        System.out.println(t);
    }

    public static void fromSpecifiedDateTimeToLocalDateTimeByOf() {
        LocalDate d = LocalDate.of(2024, 11, 20);
        LocalTime t = LocalTime.of(15, 50, 50);
        LocalDateTime dt = LocalDateTime.of(2024, 11, 20, 15, 50, 50);
        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);

        LocalDateTime dt2 = LocalDateTime.of(d, t);
        System.out.println(dt2);
    }

    public static void convertISO8601StringToLocalDateTime() {
        /*
        因为 LocalDateTime、LocalDate、LocalTime 都是标准的 ISO 8601 格式
        所以，通过 字符串 解析为 LocalDateTime、LocalDate、LocalTime,
            字符串必须是标准的 ISO 8601 格式 ！！！！
         */
        LocalDate d = LocalDate.parse("2024-11-19");
        LocalTime t = LocalTime.parse("15:16:17");
        LocalDateTime dt = LocalDateTime.parse("2024-11-19T15:16:17.566");
        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);
    }
}
