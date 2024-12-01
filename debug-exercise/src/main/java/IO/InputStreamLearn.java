package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputStreamLearn {
    public static void main(String[] args) throws IOException {
        read();
//        readWithTry();
//        readWithTryResource();
//        readFile();
    }

    /**
     * 一个字节一个字节读取
     * @throws IOException
     */
    public static void read() throws IOException {
        InputStream fileInputStream = new FileInputStream("D:\\system_dirs_replace\\文档\\poems\\pkcs#8_private_key.pem");

        for (; ; ) {
            // 一次读取一个字节，返回值是字节的十进制值
            int i = fileInputStream.read();
            if (i == -1) {
                break;
            }
            System.out.println(i);
            System.out.println((char) i);  // 转为字符
        }

        // 一定不要忘记关闭数据流
        fileInputStream.close();
    }

    public static void readWithTry() throws IOException{
        InputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\system_dirs_replace\\文档\\poems\\pkcs#8_private_key.pem");
            for (; ; ) {
                // 一次读取一个字节，返回值是字节的十进制值
                int i = fileInputStream.read();
                if (i == -1) {
                    break;
                }
                System.out.println(i);
            }
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    /**
     * try(resource)的语法，只需要编写try语句，让编译器自动为我们关闭资源
     */
    public static void readWithTryResource() throws IOException {
        try (InputStream inputStream = new FileInputStream("D:\\system_dirs_replace\\文档\\poems\\pkcs#8_private_key.pem")) {
            int n;
            while ((n = inputStream.read()) != -1) {
                System.out.println(n);
            }
        }  // 编译器在此自动为我们写入finally并调用close()
        /**
         * 实际上，编译器并不会特别地为InputStream加上自动关闭。
         * 编译器只看try(resource = ...)中的对象是否实现了java.lang.AutoCloseable接口，如果实现了，就自动加上finally语句并调用close()方法。
         * InputStream和OutputStream都实现了这个接口，因此，都可以用在try(resource)中。
         */
    }

    /**
     * 在读取流的时候，一次读取一个字节并不是最高效的方法。很多流支持一次性读取多个字节到缓冲区，对于文件和网络流来说，利用缓冲区一次性读取多个字节效率往往要高很多。
     * InputStream提供了两个重载方法来支持读取多个字节：
     *
     * int read(byte[] b)：读取若干字节并填充到byte[]数组，返回读取的字节数
     * int read(byte[] b, int off, int len)：指定byte[]数组的偏移量和最大填充数
     * 利用上述方法一次读取多个字节时，需要先定义一个byte[]数组作为缓冲区，read()方法会尽可能多地读取字节到缓冲区， 但不会超过缓冲区的大小。
     * read()方法的返回值不再是字节的int值，而是返回实际读取了多少个字节。如果返回-1，表示没有更多的数据了。
     * @throws IOException
     */
    public static void readFile() throws IOException {
        String filePath = "D:\\system_dirs_replace\\文档\\poems\\pkcs#8_private_key.pem";
        try(FileInputStream fileInputStream = new FileInputStream(filePath)) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
//            System.out.println(Arrays.toString(buffer));
            int n;
            while ((n = fileInputStream.read(buffer)) != -1) { // 读取到缓冲区
//                System.out.println(Arrays.toString(buffer));
                System.out.println("read " + n + " bytes.");
            }
        }
    }
}
