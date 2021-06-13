package com.dongbao.protal.web;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.dongbao"})
@MapperScan("com.dongbao.api.ums.mapper")
public class DongbaoPortalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DongbaoPortalWebApplication.class, args);
    }

}
