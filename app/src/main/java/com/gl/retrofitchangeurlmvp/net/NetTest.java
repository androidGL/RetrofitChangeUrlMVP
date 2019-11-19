package com.gl.retrofitchangeurlmvp.net;

import java.util.HashMap;

/**
 * @Author: gl
 * @CreateDate: 2019/11/18
 * @Description:
 */
//需要拦截api及返回结果配置类
public class NetTest {
    private static HashMap<String, String> apiResponse = new HashMap<>();

    public static String isExist(String apiName) {
        init();
        for (String interceptApi : apiResponse.keySet()) {
            if (apiName.contains(interceptApi)) {
                return interceptApi;
            }
        }
        return null;
    }

    public static String getVisualResponseByApi(String apiName) {

        return apiResponse.get(apiName);
    }

    public static void init() {
        if (apiResponse.size() > 0) {
            return;
        }
        apiResponse.put("searchAuthors", "{\"result\":\"000000\",\"msg\":\"调用成功\",\"data\":{\"userid\":\"TY6XFGLSUICQ2\",\"empno\":\"Y6XFGLSUICQ2\",\"userName\":\"18938856298\",\"sex\":\"未知\",\"status\":\"普通群员\",\"idType\":\"身份证\",\"empIdNo\":\"不详\",\"mobileNo\":\"18938856298\",\"homeAddr\":null,\"claimBankNo\":null,\"accountNo\":null,\"wechat\":\"微信\",\"occupation\":null,\"nickname\":\"昵称\"}}");
        apiResponse.put("register", "{\"status\":1,\"msg\":\"调用成功\",\"data\":{\"userId\":\"20191118\",\"userType\":0,\"userBirthYear\":1994,\"userName\":\"王二小\",\"userStature\":\"185cm\",\"userWeight\":\"50kg\"}}");
        apiResponse.put("login", "{\"status\":1,\"msg\":\"调用成功\",\"data\":{\"userId\":\"20191118\",\"userType\":0,\"userBirthYear\":1994,\"userName\":\"王二小\",\"userStature\":\"185cm\",\"userWeight\":\"50kg\"}}");
//        apiResponse.put(CMUApi.ABOUT_MONEY, "{\"result\":\"000000\",\"msg\":\"调用成功\",\"data\":{\"userid\":\"TY6XFGLSUICQ2\",\"empno\":\"Y6XFGLSUICQ2\",\"userName\":\"18938856298\",\"sex\":\"未知\",\"status\":\"普通群员\",\"idType\":\"身份证\",\"empIdNo\":\"不详\",\"mobileNo\":\"18938856298\",\"homeAddr\":null,\"claimBankNo\":null,\"accountNo\":null,\"wechat\":\"微信\",\"occupation\":null,\"nickname\":\"昵称\"}}");
    }
}
