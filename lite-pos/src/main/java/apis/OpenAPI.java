package apis;

import com.alibaba.fastjson.JSONObject;

public interface OpenAPI {

    public void purchase(JSONObject body);

    public void orderQuery(JSONObject body);
}
