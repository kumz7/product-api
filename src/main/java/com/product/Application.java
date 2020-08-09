package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.product")
public class Application{
    public static void main(String as[]){
        SpringApplication.run(Application.class, as);
    }
}