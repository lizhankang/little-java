package JavaBasic.ProcessControl;

import java.util.Scanner;

public class 输入和输出 {

    public static void main(String[] args) {
//        evertPrint();
        input();
    }

    // 输出
    public static void evertPrint() {
        /*
        System.out.println()：表示输出并换行
        System.out.print()：表示输出不换行
        System.out.printf()：格式化输出, 通过使用占位符%?，printf()可以把后面的参数格式化成指定格式
            多种占位符:
                %d: 格式化输出整数
                %x: 格式化输出十六进制整数
                %f: 格式化输出浮点数
                %e: 格式化输出科学计数法表示的浮点数
                %s: 格式化字符串
         */
        int n = 12345000;
        System.out.printf("n=%d, hex=%08x\n", n, n);

        double d = 3.1415926;
        System.out.printf("E=%e", d);
    }


    // 输入
    public static void input() {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.print("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出
    }
}
