package com.example.kevinzhou.demo.model;

public class ResponseBase {
    private int code;  //200为成功   非200为失败
    private String message;
    private Object data;

    public static ResponseBase success(){
        ResponseBase responseBase = new ResponseBase();
        responseBase.setCode(200);
        return responseBase;
    }

    public static ResponseBase success(Object data){
        ResponseBase responseBase = success();
        responseBase.setData(data);
        return responseBase;
    }

    public static ResponseBase error(int code,String message){
        ResponseBase responseBase = new ResponseBase();
        responseBase.setCode(code);
        responseBase.setMessage(message);
        return responseBase;
    }

    //默认是异常
    public static ResponseBase error(String message){
        ResponseBase responseBase = new ResponseBase();
        responseBase.setCode(10000);
        responseBase.setMessage(message);
        return responseBase;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
