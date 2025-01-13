package com.boje.h5skemaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:CredInfo.properties")
public class H5SkemaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(H5SkemaProjectApplication.class, args);
    }

}
