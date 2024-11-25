package ObjectOrientedProgramming;


/**
 * 子类可以覆写父类的方法（Override），覆写在子类中改变了父类方法的行为；
 * Java的方法调用总是作用于运行期对象的实际类型，这种行为称为多态；
 * final修饰符有多种作用：
 *      final修饰的方法可以阻止被覆写；
 *      final修饰的class可以阻止被继承；
 *      final修饰的field必须在创建对象时初始化，随后不可修改。
 *
 * 覆写Object方法
 * 因为所有的class最终都继承自Object，而Object定义了几个重要的方法：
 * toString()：把instance输出为String；
 * equals()：判断两个instance是否逻辑相等；
 * hashCode()：计算一个instance的哈希值。
 */
public class 多态 {

    public static void main(String[] args) {
        /*
        多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法
         */
        Person5 p = new Student5();
        p.run(); // 应该打印Person.run还是Student.run? Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。

        /*
        多态的特性就是，运行期才能动态决定调用的子类方法。对某个类型调用某个方法，执行的实际方法可能是某个子类的覆写方法。
         */
        Person5 person5 = new Person5();
        runTwice(p);
        runTwice(person5);
    }

    public static void runTwice(Person5 p) {
        p.run();
        p.run();
    }
}

class Person5 {
    public void run() {
        System.out.println("Person.run");
    }
}

class Student5 extends Person5 {

    // Override和Overload不同的是，如果方法签名不同，就是Overload，Overload方法是一个新方法；
    // 如果方法签名相同，并且返回值也相同，就是Override
    // 方法名相同，方法参数相同，但方法返回值不同，也是不同的方法。在Java程序中，出现这种情况，编译器会报错。
    @Override
    public void run() {
        System.out.println("Student.run");
        // 子类的覆写方法中，如果要调用父类的被覆写的方法，可以通过super来调用
        super.run();
    }
}

