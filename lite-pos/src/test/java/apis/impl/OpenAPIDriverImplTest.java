package apis.impl;

import IO.ResourceReader;
import apis.OpenAPIDriver;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


class OpenAPIDriverImplTest {

    OpenAPIDriver openAPIDriver;

    @BeforeEach
    public void setUp() {
        this.openAPIDriver = new OpenAPIDriverImpl();
    }

    @AfterEach
    public void tearDown() {
        this.openAPIDriver = null;
    }

    @Test
    void purchase() {
        JSONObject body = new JSONObject();
        body.put("brand_code", "700001");
        body.put("store_sn", "li-pu-01");
        this.openAPIDriver.purchase(body);
    }

    @Test
    void orderQuery() {
        JSONObject body = new JSONObject();
        body.put("brand_code", "700001");
        body.put("order_sn", "7903247729055347");
        this.openAPIDriver.orderQuery(body);
    }

    @Test
    void readFile() {
        ResourceReader.readFile("pems/priKey.pem");
    }

    @Test
    void authCodeQuery() {
        JSONObject body = new JSONObject();
        body.put("brand_code", "999888");
        body.put("dynamic_id", "43785657515055965062");
        this.openAPIDriver.authCodeQuery(body);
    }
}