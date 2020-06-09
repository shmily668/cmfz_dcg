package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.dao")       //包扫描
public class CmfzDcgApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmfzDcgApplication.class, args);

        System.out.println("哈哈哈!");
    }

}
