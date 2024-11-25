package JavaBasic.ProcessControl;

public class ForCycle {


    public static void main(String[] args) {
//        commonForCycle();
//        forEachCycle();
        breakAndContinue();
    }

    public static void commonForCycle() {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i=0; i<ns.length; i++) {  // 在for循环执行前，会先执行初始化语句int i=1
            System.out.println(ns[i]);
            i = i + 1;
        }
    }

    public static void forEachCycle() {
        /*
        和for循环相比，for each循环的变量n不再是计数器，而是直接对应到数组的每个元素。
        for each循环的写法也更简洁。但是，for each循环无法指定遍历顺序，也无法获取数组的索引。
        除了数组外，for each循环能够遍历所有“可迭代”的数据类型，包括后面会介绍的List、Map等。
         */
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int n : ns) {
            System.out.println(n);
        }
    }

    public static void breakAndContinue() {
        /*
        break会跳出当前循环，也就是整个循环都不会执行了。
        而continue则是提前结束本次循环，直接继续执行下次循环。
         */
        int[] n = {1,2,3,4,5,6,6};
        for (int i = 0; i < 8; i++) {
            if (i == 4) {
                System.out.println("这是第 4 次 循环");
                continue;

            }
            for (int y:
                 n) {
                if (y == 4) {
                    break;
                }else {
                    System.out.printf("第 %d 次循环中，第 %d 次打印\n", i, y);
                }
            }

        }
    }
}
