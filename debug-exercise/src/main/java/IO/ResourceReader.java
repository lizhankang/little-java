package IO;

import com.alibaba.fastjson.JSONObject;
import java.nio.file.Paths;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 读取resource目录下文件
 */
public class ResourceReader {
    public static void main(String[] args) {
//        readJsonFile("");
        readFile("pems/priKey.pem");
    }


    public static void readJsonFile(String filePath) {
        // 使用ClassLoader读取资源文件
        InputStream inputStream = ResourceReader.class.getClassLoader().getResourceAsStream("conf.json");
        if (inputStream == null) {
            System.out.println("资源文件未找到");
            return;
        }

        // 使用Scanner读取输入流内容
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name());
        String jsonContent = scanner.useDelimiter("\\A").next();
        scanner.close();

        JSONObject jsonObject = JSONObject.parseObject(jsonContent);
        System.out.println(jsonObject);
    }

    public static void readFile(String name) {

        // 使用ClassLoader读取资源文件
        InputStream inputStream = ResourceReader.class.getClassLoader().getResourceAsStream(name);
        if (inputStream == null) {
            System.out.println("资源文件未找到");
            return;
        }

        // 使用Scanner读取输入流内容
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name());
        String jsonContent = scanner.useDelimiter("\\A").next();
        scanner.close();
        System.out.println(jsonContent);

        String currentPath = Paths.get("").toAbsolutePath().toString();
        System.out.println("Current working directory: " + currentPath);

    }
}
