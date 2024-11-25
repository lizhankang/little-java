package DateAndTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 如果要自定义输出的格式，或者要把一个非ISO 8601格式的字符串解析成LocalDateTime，
 * 可以使用新的DateTimeFormatter
 */
public class DateTimeFormatterLearn {

    public static void main(String[] args) {
//        customOutput();
        parseCustomPatternDateTime();
    }


    /*
    自定义格式输出
     */
    public static void customOutput() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);
    }

    /*
    自定义格式时间进行解析
     */
    public static void parseCustomPatternDateTime() {
        DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String customDatetime = "2024/10/20 18:30:35";
        LocalDateTime localDateTime = LocalDateTime.parse(customDatetime, dateTimePattern);
        System.out.println(localDateTime);
    }
}
