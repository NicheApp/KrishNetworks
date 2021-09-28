package com.nishkarsh.kirishnetwork.model;

public class Root{
    public int code;
    public Data data;
    public String status;
    Root(int code,Data data,String status){
        this.code=code;
        this.data=data;
        this.status=status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
