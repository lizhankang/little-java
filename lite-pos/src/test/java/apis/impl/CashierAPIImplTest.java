package apis.impl;

import apis.CashierAPI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierAPIImplTest {
    CashierAPI cashierAPI;

    @BeforeEach
    public void setUp() {
        this.cashierAPI = new CashierAPIImpl();
    }

    @AfterEach
    public void tearDown() {
        this.cashierAPI = null;
    }

    @Test
    void orderDetail() {
        String orderToken = "";
        this.cashierAPI.orderDetail(orderToken);
    }
}