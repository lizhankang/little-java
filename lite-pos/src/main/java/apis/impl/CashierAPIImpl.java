package apis.impl;

import apis.CashierAPI;
import httpClient.OkHttp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class CashierAPIImpl implements CashierAPI {
    @Override
    public void orderDetail(String orderToken) {
        String url = "https://vapi.shouqianba.com/api/lpos/cashier/v2/cashier?order_token=" + orderToken;
        String response = OkHttp.get(url);
        System.out.println(JSON.toJSONString(JSON.parseObject(response), SerializerFeature.PrettyFormat));
    }
}
