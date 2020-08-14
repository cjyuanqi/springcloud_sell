package com.essa.bootpre.utils;

import com.essa.bootpre.domain.Result;

public class ResultUtils {

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result ret = new Result();
        ret.setCode(code);
        ret.setMsg(msg);
        return ret;
    }


}
