package com.sunny.sportwomen.pojo;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 错误码定义
 * @author YangFan
 * @version 1.0
 * @date 2021/4/7 15:26
 */
public enum ApiResponseCode {
    /**
     * 未认证
     */
    Unauthorized("40001", "Unauthorized"),

    /**
     * 参数不合法
     */
    InvalidArgument("40002", "invalid argument"),

    /**
     * 系统内部异常
     */
    InternalError("-1", "internal error"),

    OK("00000", "success"),
    ;

    final String code;

    final String message;

    ApiResponseCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    public static ApiResponseCode convert(String code){
        ApiResponseCode[] values = values();

        for (ApiResponseCode value : values){
            if (value.code.equals(code)){
                return value;
            }
        }
        return null;
    }
}
