package com.ratta;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.ratta.mapper"})
@SpringBootApplication
public class SpringbootSpringsecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpringsecurityJwtApplication.class, args);
    }

}
