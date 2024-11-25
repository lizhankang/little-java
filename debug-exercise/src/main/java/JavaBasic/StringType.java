package JavaBasic;

public class StringType {

    public static void main(String[] args) {
        /*
        == 运算符：比较两个对象的引用（内存地址），而不是内容。
            对于字面量（如 "hello"），Java 会在字符串池中缓存相同的字符串，因此两个字面量 "hello" 的引用是相同的，所以 s1 == s2 返回 true。
        String.toLowerCase() 方法：当你使用 toLowerCase() 方法时，返回的是一个新的字符串对象，尽管其内容可能相同，但它们在内存中的引用不同。
            因此，s3 是通过 toLowerCase() 方法生成的一个新对象，所以 s1 == s3 返回 false。
         */
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2); // true，因为引用相同

        String s3 = "HELLO".toLowerCase();
        System.out.println(s1 == s3); // false，因为引用不同

        System.out.println(s1.equals(s3)); // true，因为内容相同

        /*
        使用 == 比较的是对象的引用，而不是内容。
        使用 .equals() 方法比较的是两个字符串的内容，返回 true 如果内容相同。
        在比较字符串内容时，推荐使用 .equals() 方法。
         */
    }
}
