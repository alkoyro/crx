package com.ak.crx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * entry point of application
 */
@SpringBootApplication(scanBasePackages = "com.ak.crx")
public class HillApp {

    public static void main(String[] args) {
        SpringApplication.run(HillApp.class, args);
    }
}
