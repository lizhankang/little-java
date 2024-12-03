package apis;

import com.alibaba.fastjson.JSONObject;

public interface OpenAPIDriver {

    public void purchase(JSONObject body);

    public void orderQuery(JSONObject body);

    public void iPay(JSONObject body);

    public void Refund(JSONObject body);

    public void authCodeQuery(JSONObject body);
}
