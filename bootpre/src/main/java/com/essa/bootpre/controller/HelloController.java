package com.essa.bootpre.controller;

import com.essa.bootpre.config.GirlConfig;
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
    public String info() {
        return "MixMoney:" + mixMoney + " description:" + note;
    }

    @GetMapping("/sign")
    public String get() {
        return "follow big brother Liao";
    }

    @RequestMapping(value = {"/say","/hi"}, method = RequestMethod.GET)
    public GirlConfig say(@PathVariable("id") Integer id) {
        return girl;
    }
}
