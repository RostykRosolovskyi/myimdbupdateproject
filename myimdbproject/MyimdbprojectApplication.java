package com.example.myimdbproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyimdbprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyimdbprojectApplication.class, args);
    }

}
