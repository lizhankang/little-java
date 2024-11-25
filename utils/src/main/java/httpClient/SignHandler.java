package httpClient;

import java.io.File;
import java.util.Base64;
import java.io.FileReader;
import java.io.IOException;
import java.security.Security;
import java.security.Signature;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.nio.charset.StandardCharsets;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SignHandler {
    private static final String SHA1WithRSA = "SHA1WithRSA";
    private static final String SHA256WithRSA = "SHA256WithRSA";

    /**
     * 读取密钥文件中密钥字符串(去除密钥头)
     */
    public static String readKeyContent(String filePath) throws IOException {
        StringBuilder keyBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(new File(filePath), StandardCharsets.UTF_8)) {
            char[] buffer = new char[1024];
            int numRead;
            while ((numRead = reader.read(buffer)) != -1) {
                keyBuilder.append(buffer, 0, numRead);
            }
        }

        // 获取pem文件Content
        String keyContent = keyBuilder.toString();
//        System.out.println(keyContent);

        // 使用正则表达式去除密钥文件的头部和尾部标记
        keyContent = keyContent.replaceAll("-----BEGIN (.*) KEY-----", "")
                .replaceAll("-----END (.*) KEY-----", "")
                .replaceAll("\\s+", "");  // 去除所有空格和换行符

        return keyContent;
    }

    /**
     * 获取私钥对象：支持 PKCS#8 与 PKCS#1 格式的私钥文件
     */
    public static PrivateKey getPrivateKey(String filePath) throws Exception {

        String privateKeyContent = readKeyContent(filePath);

        byte[] keyBytes = Base64.getDecoder().decode(privateKeyContent.getBytes());

        PrivateKey privateKey;

        try {
            // 如果是PKCS#8格式的密钥
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            // 使用RSA算法获取PrivateKey对象
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            // 如果密钥格式错误报错：java.security.spec.InvalidKeySpecException:
            //      java.security.InvalidKeyException: IOException : algid parse error, not a sequence  则是密钥格式错误
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException invalidKeySpecException) {
            // 如果是PKCS#1格式的密钥： 先强转成PKCS#1格式的密钥
            Security.addProvider(new BouncyCastleProvider());
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(keySpec);

        }
        return privateKey;
    }

    /**
     * 计算签名值
     */
    public static String sign(String data, String privateKeyPath, String algorithm) {
        try {
            PrivateKey privateKey = getPrivateKey(privateKeyPath);
            Signature signature = Signature.getInstance(algorithm);
            signature.initSign(privateKey);
            signature.update(data.getBytes(StandardCharsets.UTF_8));
            byte[] signed = signature.sign();
            return Base64.getEncoder().encodeToString(signed);
        } catch (Exception exception) {
            return exception.toString();
        }
    }

    public static String sign(String data, String privateKeyPath) {
        return sign(data, privateKeyPath, SHA256WithRSA);
    }

    public static String sign(String data) {
        String privateKeyPath = "D:\\system_dirs_replace\\文档\\poems\\prod_clientPriKey.pem";
        return sign(data, privateKeyPath, SHA256WithRSA);
    }





    public static void main(String[] args) {
        try {
            String keyFile = "D:\\system_dirs_replace\\文档\\poems\\pkcs#8_private_key.pem";
            String keyContent = readKeyContent(keyFile);
            System.out.println(keyContent);

            System.out.println(getPrivateKey(keyFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
