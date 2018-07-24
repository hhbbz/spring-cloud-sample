package com.example.springCloudServiceApi.api.v1.util;

public  class ApiResponseBody<T> extends StatefulBody {

    public ApiResponseBody(){
        super();
    }

    public ApiResponseBody(Integer code, Integer status, String message,T payload){
        super(code,status,message,payload);
    }

}
