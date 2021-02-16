package com.wb.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProApplication.class, args);
    }

}
