package ObjectOrientedProgramming;

public class 封装 {
    public static void main(String[] args) {
        Student4 student4 = new Student4();

    }
}


class Person {
    public String name;  // 默认初始化为null
    public int age;  // 默认初始化为0

    public Person() {
        /*
        如果一个类没有定义构造方法，编译器会自动为我们生成一个默认构造方法，它没有参数，也没有执行语句
        如果我们自定义了一个构造方法，那么，编译器就不再自动创建默认构造方法
        如果既要能使用带参数的构造方法，又想保留不带参数的构造方法，那么只能把两个构造方法都定义出来
         */
    }

    public Person(String name, int age) {
        /*
        由于构造方法是如此特殊，所以构造方法的名称就是类名。构造方法的参数没有限制，在方法内部，也可以编写任意语句。
        但是，和普通方法相比，构造方法没有返回值（也没有void），调用构造方法，必须用new操作符。
         */
        this.name = name;
        this.age = age;
    }
    /*
    在Java中，创建对象实例的时候，按照如下顺序进行初始化：

    先初始化字段，例如，int age = 10;表示字段初始化为10，double salary;表示字段默认初始化为0，String s;表示引用类型字段默认初始化为null；
    执行构造方法的代码进行初始化。
    因此，构造方法的代码由于后运行，所以，new Person("Xiao Ming", 12)的字段值最终由构造方法的代码确定。
     */


}


/**
 * private修饰 的field、method 只能在该类中被调用、执行，子类也无权访问
 */
class Person2 {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }
}


/**
 * 可变参数
 *  相当于 数组类型的参数，但是如果明确定义为数组类型的话，调用方需要自己先构造String[]，比较麻烦
 *  而可变参数可以保证 null不可被传入，因为传入0个参数时，接收到的实际值是一个空数组而不是null
 */

class Group {
    private String[] names;

    public static void main(String[] args) {
        Group g = new Group();
        g.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
        g.setNames("Xiao Ming", "Xiao Hong"); // 传入2个String
        g.setNames("Xiao Ming"); // 传入1个String
        g.setNames(); // 传入0个String
    }

    public void setNames(String... names) {
        this.names = names;
    }
}


/**
 * 重载
 *  在一个类中，我们可以定义多个方法。
 *  如果有一系列方法，它们的功能都是类似的，只有参数有所不同，那么，可以把这一组方法名做成同名方法
 */
class Hello {
    public void hello() {
        System.out.println("Hello, world!");
    }

    /*
    这种方法名相同，但各自的参数不同，称为方法重载（Overload）。
    注意：方法重载的返回值类型通常都是相同的。
    方法重载的目的是，功能类似的方法使用同一名字，更容易记住，因此，调用起来更简单。
     */
    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
}

/**
 * 实例字段在每个实例中都有自己的一个独立“空间”，但是静态字段只有一个共享“空间”，所有实例都会共享该字段
 * 对于静态字段，无论修改哪个实例的静态字段，效果都是一样的：所有实例的静态字段都被修改了，原因是静态字段并不属于实例
 * 所以，所有实例共享一个静态字段
 * 推荐用类名来访问静态字段。可以把静态字段理解为描述class本身的字段
 *
 * 有静态字段，就有静态方法。用static修饰的方法称为静态方法。
 * 调用实例方法必须通过一个实例变量，而调用静态方法则不需要实例变量，通过类名就可以调用。
 * 因为静态方法属于class而不属于实例，因此，静态方法内部，无法访问this变量，也无法访问实例字段，它只能访问静态字段。
 * 通过实例变量也可以调用静态方法，但这只是编译器自动帮我们把实例改写成类名而已。
 * 通常情况下，通过实例变量访问静态字段和静态方法，会得到一个编译警告。
 * 静态方法经常用于工具类。例如：
 * Arrays.sort()
 * Math.random()
 * 静态方法也经常用于辅助方法。注意到Java程序的入口main()也是静态方法。
 *
 * 因为interface是一个纯抽象类，所以它不能定义实例字段。但是，interface是可以有静态字段的，并且静态字段必须为final类型
 * 编译器会自动把该字段变为public static final类型。
 *
 * 静态字段属于所有实例“共享”的字段，实际上是属于class的字段；
 * 调用静态方法不需要实例，无法访问this，但可以访问静态字段和其他静态方法；
 * 静态方法常用于工具类和辅助方法。
 */

/**
 * 访问修饰符
 *      public: 可以用来修饰 类、方法、字段；可以被任何使用与访问
 *      protected: 可以被其子类或子类的子类访问
 *      package: 无任何修饰符的类、方法、字段访问
 *      private: 只有在本类内部访问，子类都无权访问
 */
