import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class JavaCoreClass {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "hello";
        byte[] bytes = s.getBytes("utf-8");
        System.out.println(Arrays.toString(bytes));
        for (byte b: bytes
             ) {
            System.out.println(b);
            System.out.println();
        }

        byte[] bytes1 = s.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes1));

        char[] cs = "Hello".toCharArray(); // String -> char[]
        String s1 = new String(cs); // char[] -> String
        System.out.println(s1);
        System.out.println(Arrays.toString(cs));

        // 快速将一个字符串列表 拼接为 一个字符串
        String[] names = {"Bob", "Alice", "Grace"};
        var s2 = String.join(", ", names);


        // 快速将一个字符串 拼接为 指定开头与结尾 的字符串
        String[] names1 = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names1) {
            sj.add(name);
        }
        System.out.println(sj.toString());

        // 快速的将一个字符串数组 拼接为 无拼接符的新字符串
        String[] names3 = {"Bob", "Alice", "Grace"};
        var sb = new StringBuilder();
        sb.append("Hello ");
        for (String name : names3) {
            sb.append(name).append(", ");
        }

    }
}
