package JavaBasic.ArrayOperations;

import java.util.Arrays;

/**
 * 必须注意，对数组排序实际上修改了 数组本身 !!!
 */

public class ArraySorting {

    public static void main(String[] args) {
//        bubbleSort();
        sortSort();
    }

    public static void bubbleSort() {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println(Arrays.toString(ns));
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] > ns[j+1]) {
                    // 交换ns[j]和ns[j+1]:
                    int tmp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = tmp;
                }
            }
        }
        // 排序后:
        System.out.println(Arrays.toString(ns));
    }

    public static void sortSort() {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        System.out.println(Arrays.toString(ns));
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));
    }
}
