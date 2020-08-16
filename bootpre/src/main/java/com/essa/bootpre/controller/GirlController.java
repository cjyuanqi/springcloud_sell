package com.essa.bootpre.controller;


import com.essa.bootpre.domain.Girl;
import com.essa.bootpre.domain.Result;
import com.essa.bootpre.repository.GirlRepository;
import com.essa.bootpre.service.GirlService;
import com.essa.bootpre.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {


    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Resource
    private GirlService girlService;

    @Resource
    private GirlRepository girlRepository;


    /**
     * 获取信息列表
     * @return
     */
    @GetMapping("/girls")
    public Result girls() {
        return ResultUtils.success(girlService.findAll());
    }


    /**
     * 添加信息
     * @param girl
     * @param bindingResult
     * @return
     */
    @PostMapping("/girl/add")
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error(1, bindingResult.getFieldError().toString());
        }
        return ResultUtils.success(girlService.add(girl));
    }


    /**
     * 更新信息
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping("/girl/{id}")
    public Result girlUpdate(@PathVariable("id") Integer id,
                             @RequestParam("cupSize") String cupSize,
                             @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return ResultUtils.success(girlRepository.save(girl));
    }


    @DeleteMapping(value = "/girl/{id}")
    public Result girlDelete(@PathVariable("id")Integer id) {
        girlRepository.deleteById(id);
        return ResultUtils.success();
    }


    @GetMapping("/girl/age/{age}")
    public Result girlListByAge(@PathVariable("age") Integer age) {
        return ResultUtils.success(girlRepository.findByAge(age));
    }

    @GetMapping("/girl/getAge/{id}")
    public Result getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
        return ResultUtils.success();
    }







}
