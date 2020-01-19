package com.example.json_resolve;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class HttpUtilTest {

    @Test
    public void testSendHttpRequest() {
        String address = "http://hao123.com";
        String response = null;
        try {
            response = HttpUtil.sendHttpRequest(address);
        }catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        Assert.assertNotNull(response);
        Assert.assertFalse(response.contains("Error"));
    }
}
