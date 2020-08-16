package com.essa.bootpre.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(1,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你可能还在上中学")
    ;


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
