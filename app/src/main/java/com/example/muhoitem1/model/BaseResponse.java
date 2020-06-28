package com.example.muhoitem1.model;

public class BaseResponse<T> {

    /**
     * data : []
     * statusCode : 0
     * message :
     */

    //statusCode = 200代表执行成功，非0都为失败
    private int stateCode;
    private String message;
    private T data;

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
