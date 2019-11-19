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

    /**
     * 判断这个URL是不是需要拦截，如果需要拦截就返回interceptApi，即apiResponse的key值
     * @param apiName 需要拦截的URL
     * @return
     */
    public static String isExist(String apiName) {
        //初始化apiResponse，添加键值对
        init();
        for (String interceptApi : apiResponse.keySet()) {
            if (apiName.contains(interceptApi)) {
                return interceptApi;
            }
        }
        return null;
    }

    /**
     * 根据键值对获取需要替换的响应值
     * @param apiName
     * @return
     */
    public static String getVisualResponseByApi(String apiName) {
        return apiResponse.get(apiName);
    }

    public static void init() {
        if (apiResponse.size() > 0) {
            return;
        }
        apiResponse.put("register", "{\"status\":1,\"msg\":\"调用成功\",\"data\":{\"userId\":\"20191118\",\"userType\":0,\"userBirthYear\":1994,\"userName\":\"王二小\",\"userStature\":\"185cm\",\"userWeight\":\"50kg\"}}");
        apiResponse.put("login", "{\"status\":1,\"msg\":\"调用成功\",\"data\":{\"userId\":\"20191118\",\"userType\":0,\"userBirthYear\":1994,\"userName\":\"王二小\",\"userStature\":\"185cm\",\"userWeight\":\"50kg\"}}");
    }
}
