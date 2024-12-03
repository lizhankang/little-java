package apis.impl;

import apis.CashierAPIDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CashierAPIDriverImplTest {
    CashierAPIDriver cashierAPIDriver;

    @BeforeEach
    public void setUp() {
        this.cashierAPIDriver = new CashierAPIDriverImpl();
    }

    @AfterEach
    public void tearDown() {
        this.cashierAPIDriver = null;
    }

    @Test
    void orderDetail() {
        String orderToken = "";
        this.cashierAPIDriver.orderDetail(orderToken);
    }
}