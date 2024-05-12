package com.atguigu.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

;

@Data
@Accessors(chain = true)
public class ResultData<T> {
    private String code;
    private String message;
    private T data;
    private long tiemstamp;

    public ResultData(){
        this.tiemstamp = System.currentTimeMillis();
    }

    public static <T> ResultData success(T data){
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData fail(String code,String message){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setCode(message);
        resultData.setData(null);
        return resultData;
    }

}
