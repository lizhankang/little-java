package ObjectOrientedProgramming;


/**
 * 继承是面向对象编程的一种强大的代码复用方式；
 * Java只允许单继承，所有类最终的根类是Object；
 * protected允许子类访问父类的字段和方法；
 * 子类的构造方法可以通过super()调用父类的构造方法；
 * 可以安全地向上转型为更抽象的类型；
 * 可以强制向下转型，最好借助instanceof判断；
 * 子类和父类的关系是is，has关系不能用继承。
 */
public class 继承 {
}

class Person3 {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age=age;
    }
}

class Student3 extends Person3 {
    // 不要重复name和age字段/方法,
    // 只需要定义新增score字段/方法:
    // 子类自动获得了父类的所有字段，严禁定义与父类重名的字段！
    // 继承有个特点，就是子类无法访问父类的private字段或者private方法。
    // 为了让子类可以访问父类的字段，我们需要把private改为protected。用protected修饰的字段可以被子类访问
    private int score;



    public int getScore() {
        return this.score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}

// 正常情况下，只要某个class没有final修饰符，那么任何类都可以从该class继承
class Person4 {
    // 为了让子类可以访问父类的字段，我们需要把private改为protected
    protected String name;
    protected int age;

    public Person4() {

    }

    public Person4(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student4 extends Person4 {
    protected int score;
    public Student4() {
        super();

    }

    public Student4(String name, int age, int score) {
        super(name, age); // 调用父类的构造方法Person(String, int)
        this.score = score;
    }
    public String hello() {
        return "Hello, " + name; // OK!
    }

    private void privateMethod() {

    }

    void packageMethod() {

    }
}


class 向上转型 {
    public static void main(String[] args) {
        Student4 s = new Student4();
        Person4 p = new Student4();  // 这种把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）。
        // instanceof实际上判断一个变量所指向的实例是否是指定类型，或者这个类型的子类。如果一个引用变量为null，那么对任何instanceof的判断都为false。
        System.out.println(p instanceof Student4);
    }


}

