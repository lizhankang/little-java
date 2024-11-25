package JavaBasic.ProcessControl;

public class WhileCycle {

    public static void main(String[] args) {
        doWhileCycle();
    }

    public static void whileCycle() {
        int sum = 0; // 累加的和，初始化为0
        int n = 1;
        while (n <= 100) { // 循环条件是n <= 100
            sum = sum + n; // 把n累加到sum中
            n ++; // n自身加1
        }
        System.out.println(sum); // 5050
    }

    public static void doWhileCycle() {
        /*
        do while先执行循环，再判断条件；
        do while循环会至少执行一次。
         */
        int sum = 0;
        int m = 20;
        int n = 100;
        // 使用do while计算M+...+N:
        do {
        } while (false);
        System.out.println(sum);

    }
}
