package com.essa.bootpre.controller;

import com.essa.bootpre.config.GirlConfig;
import com.essa.bootpre.domain.Result;
import com.essa.bootpre.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Value("${minMoney}")
    private float mixMoney;

    @Value("${description}")
    private String note;

    @Autowired
    private GirlConfig girl;

    @GetMapping("/info")
    public Result info() {
        return ResultUtils.success("MixMoney:" + mixMoney + " description:" + note);
    }

    @GetMapping("/sign")
    public Result get() {
        return ResultUtils.success("follow big brother Liao");
    }

    @RequestMapping(value = {"/say","/hi"}, method = RequestMethod.GET)
    public Result say(@PathVariable("id") Integer id) {
        return ResultUtils.success(girl);
    }
}
