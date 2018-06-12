package net.skycrown.cuteassistant.network.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wjd on 2018/6/10.
 * 服务器返回结果
 */

public class BaseBean<T> {
    @SerializedName("results")
    private T data;
    private String code;
    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
