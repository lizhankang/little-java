package JavaBasic.ArrayOperations;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PrintArrays {

    public static void main(String[] args) {
//        printByForCycle();
        printArray();
    }

    public static void printByForCycle() {
        // 通过索引遍历数组
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i=0; i<ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }
    }


    public static void printByForEachCycle() {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int n : ns) {
            System.out.println(n);
        }
    }

    public static void printArray() {
        int[] ns = { 1, 1, 2, 3, 5, 8 };
        System.out.println(ns);  // 直接打印数组变量，得到的是数组在JVM中的引用地址
        // 使用Arrays.toString()可以快速获取数组内容。
        System.out.println(Arrays.toString(ns));
    }
}
