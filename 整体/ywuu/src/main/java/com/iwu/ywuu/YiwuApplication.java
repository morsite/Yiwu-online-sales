package com.iwu.ywuu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iwu.ywuu.mapper")
public class YiwuApplication {
    public static void main(String[] args) {
        SpringApplication.run(YiwuApplication.class,args);
    }
}
