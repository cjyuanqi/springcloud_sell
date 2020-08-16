package com.essa.bootpre.exceptions;

import com.essa.bootpre.enums.ResultEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }



}
