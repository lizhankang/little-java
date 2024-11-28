package IO;

public class CheckOS {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        if (osName.equals("Linux")) {
            System.out.println("运行在Linux操作系统上");
        } else if (osName.equals("Windows")) {
            System.out.println("运行在Windows操作系统上");
        } else if (osName.equals("Mac OS X")) {
            System.out.println("运行在Mac OS X操作系统上");
        } else {
            System.out.println("运行在其他操作系统上: " + osName);
        }
    }
}
