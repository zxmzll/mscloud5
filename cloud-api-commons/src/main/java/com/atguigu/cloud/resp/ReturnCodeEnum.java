package com.atguigu.cloud.resp;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ReturnCodeEnum {
//1举值
    RC200("200","操作成功!"),
    RC999("999","操作失败"),
    RC204("204","授权不通过"),
    RC404("404","路径错误"),
    RC500("500","服务器问题");

//    对于枚举编写
//    举值-构造-遍历

//    2构造
    private final String code;
    private final String message;


    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

//    遍历
//    传统版
    public static ReturnCodeEnum getRcEnuV1(String code){
        for (ReturnCodeEnum element : ReturnCodeEnum.values()) {
            if (element.getCode().equalsIgnoreCase(code)){
                return element;
            }

        }
        return null;
    }

//    stream流失计算版
public static ReturnCodeEnum getRcEnuV2(String code){
       return Arrays.stream(ReturnCodeEnum.values()).filter(x ->  x.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
}

    public static void main(String[] args) {
        System.out.printf(String.valueOf(getRcEnuV2("404")));
        System.out.printf(String.valueOf(getRcEnuV2("404").getMessage()));
        System.out.printf(String.valueOf(getRcEnuV2("404").getCode()));
    }
}
