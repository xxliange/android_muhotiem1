package com.example.muhoitem1.model.network;

public class CustomException {
    public static final int UNKONE = 1000;
    public static ApiException handleException(Throwable e){
        ApiException ex;
        ex = new ApiException(UNKONE,e.getMessage());
        return ex;
    }
}
