package JavaBasic.ArrayOperations;

import java.util.Arrays;

public class MultidimensionalArrays {
    public static void main(String[] args) {
//        printMultidimensionalArraysByForCycle();
        printMultidimensionalArraysByArraysDeepToString();
    }


    public static void printMultidimensionalArraysByForCycle() {
        int[][] ns = {
                { 1, 2, 3, 4 },
                { 5, 6 },
                { 7, 8, 9 }
        };
        for (int[] arr : ns) {
            for (int n : arr) {
                System.out.print(n);
                System.out.print(',');
            }
            System.out.println();
        }
    }

    public static void printMultidimensionalArraysByArraysDeepToString() {
        int[][] ns = {
                { 1, 2, 3, 4 },
                { 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(Arrays.deepToString(ns));
    }
}
