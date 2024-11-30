package apis.impl;

import IO.ResourceReader;
import apis.OpenAPI;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


class OpenAPIImplTest {

    OpenAPI openAPI;

    @BeforeEach
    public void setUp() {
        this.openAPI = new OpenAPIImpl();
    }

    @AfterEach
    public void tearDown() {
        this.openAPI = null;
    }

    @Test
    void purchase() {
        JSONObject body = new JSONObject();
        body.put("brand_code", "700001");
        body.put("store_sn", "li-pu-01");
        this.openAPI.purchase(body);
    }

    @Test
    void orderQuery() {
        JSONObject body = new JSONObject();
        body.put("brand_code", "700001");
        body.put("order_sn", "7903247729055347");
        this.openAPI.orderQuery(body);
    }

    @Test
    void readFile() {
        ResourceReader.readFile("pems/priKey.pem");
    }
}