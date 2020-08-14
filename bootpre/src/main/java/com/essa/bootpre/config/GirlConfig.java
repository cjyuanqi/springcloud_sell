package com.essa.bootpre.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "girl")
@Data
public class GirlConfig {

    private String name;

    private int age;

    private String phone;

}
