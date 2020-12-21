package com.exercise.lottolandRPS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.exercise.lottolandRPS")
public class LottolandRpsApplication {

    public static void main(final String[] args) {
        SpringApplication.run(LottolandRpsApplication.class, args);
    }
}
