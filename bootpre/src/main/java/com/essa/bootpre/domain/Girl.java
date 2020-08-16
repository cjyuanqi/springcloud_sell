package com.essa.bootpre.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;


    @Min(value = 18, message = "未成年禁止入门")
    private Integer age;

    @NotNull
    private String cupSize;

    @NotNull(message = "金额必传")
    private double money;

    public Girl() { }
}
