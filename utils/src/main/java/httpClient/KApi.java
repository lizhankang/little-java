package httpClient;

import com.alibaba.fastjson.JSONObject;
import tool.CommonTools;

public class KApi {
    public static String get(String url) {
       return OkHttp.get(url);
    }

    public static String post(String url, JSONObject data) {
        JSONObject body = new JSONObject();
        JSONObject request = new JSONObject();
        JSONObject head = new JSONObject();
//        head.put("appid", "28lpm0000002");
        head.put("appid", "28lp467052302");
        head.put("request_time", data.get("sales_time"));
        head.put("sign_type", "SHA256");
        head.put("version", "1.0.0");
        request.put("head", head);

        request.put("body", data);
        body.put("request", request);

        String signature = SignHandler.sign(request.toJSONString());
        body.put("signature", signature);

        String jsonBody = body.toJSONString();
        return OkHttp.post(url, jsonBody);
    }
}
