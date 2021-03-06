package com.essa.bootpre.domain;

import lombok.Data;

@Data
public class Result<T> {

    /* 信息码 */
    private Integer code;

    /* 提示信息 */
    private String msg;

    /* 返回数据 */
    private T data;
}
