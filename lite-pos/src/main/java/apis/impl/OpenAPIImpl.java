package apis.impl;

import apis.OpenAPI;
import httpClient.KApi;
import tool.CommonTools;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class OpenAPIImpl implements OpenAPI {
    @Override
    public void purchase(JSONObject body) {
        String url = "https://vapi.shouqianba.com/api/lite-pos/v1/sales/purchase";

        JSONObject data = new JSONObject();
        data.put("request_id", CommonTools.generateUniqueNumber(12));
        data.put("brand_code", "910001");
        data.put("store_sn", "li-pu-01");
        data.put("workstation_sn", "01");
        data.put("amount", "100");
        data.put("scene", "4");
        data.put("currency", "156");
        data.put("industry_code", "0");
        data.put("check_sn", CommonTools.generateUniqueNumber(12));
        data.put("sales_sn", CommonTools.generateUniqueNumber(12));
        data.put("sales_time", CommonTools.getDateTime());
        data.put("subject", "Order from java");
        data.put("description", "Order from java");
        data.put("operator", "Order from java");
        data.put("customer", "Order from java");
        data.put("pos_info", "Order from java");
        data.put("reflect", "Order from java");
        data.put("disposable", "0");
        data.put("expire_time", "120");
        data.putAll(body);
        String response = KApi.post(url, data);
        System.out.println(JSON.toJSONString(JSON.parseObject(response), SerializerFeature.PrettyFormat));

    }

    @Override
    public void orderQuery(JSONObject body) {
        String url = "https://vapi.shouqianba.com/api/lite-pos/v1/sales/query";

        JSONObject data = new JSONObject();
        data.put("brand_code", "700001");
        data.put("order_sn", "7903247764886695");
        data.putAll(body);
        String response = KApi.post(url, data);
        System.out.println(JSON.toJSONString(JSON.parseObject(response), SerializerFeature.PrettyFormat));
    }
}


