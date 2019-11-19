package com.gl.retrofitchangeurlmvp.entity;

import androidx.annotation.NonNull;

/**
 * @Author: gl
 * @CreateDate: 2019/11/18
 * @Description:
 */
public class NetResponse<T> {
    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @NonNull
    @Override
    public String toString() {
        return "msg:"+msg+","+data.toString();
    }
}
