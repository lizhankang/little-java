package tool;

import com.alibaba.fastjson.JSONObject;
import httpClient.KApi;
import httpClient.OkHttp;


public class HttpApiTest {

    public static void orderDetail() {
        String url = "https://vapi.shouqianba.com/api/lpos/cashier/v2/cashier?order_token=b0ae3670db610701d3c668eb7ce5aea1";

        System.out.println(OkHttp.get(url));;
    }

    public static void orderQuery() {
        String url = "https://vapi.shouqianba.com/api/lite-pos/v1/sales/query";

        JSONObject body = new JSONObject();
        body.put("brand_code", "999888");
        body.put("order_sn", "7903247764886695");
        System.out.println(KApi.post(url, body));
    }

    public static void main(String[] args) {
        orderQuery();
    }
}
