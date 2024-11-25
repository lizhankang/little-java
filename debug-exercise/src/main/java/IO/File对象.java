package IO;

import java.io.*;

public class File对象 {
    public static void main(String[] args) throws IOException {
        operateFileFileObject();
    }

    /*
    创建File对象
     */
    public static void getFileObject()  throws IOException {
        File f = new File("D:\\system_dirs_replace\\文档\\poems\\prod_clientPriKey.pem");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
    }

    /*
    判断 File对象
        File对象既可以表示文件，也可以表示目录
     */
    public static void judgeFileObject() {
        File f1 = new File("D:\\system_dirs_replace\\文档\\poems\\prod_clientPriKey.pem");
        File f2 = new File("D:\\system_dirs_replace\\文档\\poems");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
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
