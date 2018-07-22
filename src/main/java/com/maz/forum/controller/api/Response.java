package com.maz.forum.controller.api;

public class Response {
    /**
     * 200 代表成功
     * 其他则代表失败，失败的时候，message里面会有失败的原因，成功的时候data里面包含了成功的数据
     */
    public int code;
    public Object data;
    public String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Response success(Object data) {
        Response response=  new Response();
        response.setCode(200);
        response.setData(data);
        return response;
    }

    public static Response success() {
        Response response=  new Response();
        response.setCode(200);
        return response;
    }
    public static  Response error(String message){
        Response response=new Response();
        response.setCode(500);
        response.setMessage(message);
        return  response;
    }
}
