package JavaBasic.ProcessControl;

public class IfJudgement {
    public static void main(String[] args) {
//        valueTypeJudgement(60);
        referenceTypeJudgment();
    }

    public static void valueTypeJudgement(int n) {
        if (n > 90) {
            System.out.println("优秀");
        } else if (n >= 60) {
            System.out.println("及格了");
        } else {
            System.out.println("挂科了");
        }
        System.out.println("END");
    }

    public static void referenceTypeJudgment() {
        /*
        在Java中，判断 值类型的变量 是否相等，可以使用==运算符。
        但是，判断 引用类型的变量是否相等，==表示“引用是否相等”，或者说，是否指向同一个对象。
         */
        // 例如，下面的两个String类型，它们的内容是相同的，但是，分别指向不同的对象，用==判断，结果为false
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("使用==进行判断: ");
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }

        // 要判断引用类型的变量内容是否相等，必须使用equals()方法：
        System.out.println("使用equals()方法进行判断: ");
        if (s1.equals(s2)) {  // 如果变量s1为null，会报NullPointerException
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
    }
}
