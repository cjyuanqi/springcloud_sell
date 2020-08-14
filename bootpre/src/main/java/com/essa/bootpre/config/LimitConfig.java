package com.essa.bootpre.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "limit")
@Data
public class LimitConfig {

    private float minMoney;

    private float maxMoney;

    private String description;
}
