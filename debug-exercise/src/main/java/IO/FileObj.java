package IO;

import java.io.*;
import java.util.Arrays;

public class FileObj {
    public static void main(String[] args) throws IOException {
        getFileObject();
//        judgeFileObject();
//        operateFileFileObject();
    }

    /*
    创建File对象
     */
    public static void getFileObject()  throws IOException {
        File f = new File("D:\\system_dirs_replace\\文档\\poems\\prod_clientPriKey.pem");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());

        File f2 = new File("../prod_clientPriKey.pem");
        System.out.println(f2.getPath());  // 传入的路径
        System.out.println(f2.getAbsolutePath());  // 就是当前工作路径+传入的路径
        // 返回的是规范路径。
        System.out.println(f2.getCanonicalPath());  // 根据传入的路径算出真实绝对路径

        System.out.println(File.separator); // 根据当前平台打印"\"或"/"
    }

    /*
    判断 File对象
        File对象既可以表示文件，也可以表示目录
     */
    public static void judgeFileObject() throws IOException {
        File f1 = new File("D:\\system_dirs_replace\\文档\\poems\\prod_clientPriKey.pem");
        File f2 = new File("D:\\system_dirs_replace\\文档\\poems\\");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println(Arrays.toString(f2.list()));
        System.out.println(Arrays.toString(f2.listFiles()));

        System.out.println(f1.getCanonicalPath());
        System.out.println(f2.getCanonicalPath());

        // getName(): 获取File对象 规范路径的 最后一个分隔符后的内容
        System.out.println(f1.getName());
        System.out.println(f2.getName());

        /**
         * 和文件操作类似，File对象如果表示一个目录，可以通过以下方法创建和删除目录：
         *
         *      boolean mkdir()：创建当前File对象表示的目录；
         *      boolean mkdirs()：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
         *      boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。
         */
    }

    /*
    判断 文件 File对象的权限
     */
    public static void operateFileFileObject() throws IOException {
        File f = new File("D:\\system_dirs_replace\\文档\\新联脚本22.py");
        System.out.println(f.canRead());
        System.out.println(f.canWrite());
        System.out.println(f.canExecute());
        System.out.println(f.length());
        boolean b = f.createNewFile();  // 根据 File对象在磁盘上创建一个新的文件(如果File对象中的文件不存在)

        File tempFile = File.createTempFile("tmp-", ".txt");
        tempFile.deleteOnExit(); // JVM退出时自动删除
        System.out.println(tempFile.getAbsoluteFile());
    }

}
