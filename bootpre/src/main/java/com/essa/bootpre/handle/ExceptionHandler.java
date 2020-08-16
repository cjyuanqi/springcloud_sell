package com.essa.bootpre.handle;

import com.essa.bootpre.domain.Result;
import com.essa.bootpre.enums.ResultEnum;
import com.essa.bootpre.exceptions.GirlException;
import com.essa.bootpre.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException)e;
            return ResultUtils.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.error("[系统异常] {}",e);
            return ResultUtils.error(ResultEnum.UNKNOWN_ERROR.getCode(),e.getMessage());
        }
    }

}
