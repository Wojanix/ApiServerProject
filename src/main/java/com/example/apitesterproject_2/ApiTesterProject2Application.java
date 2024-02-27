package com.example.apitesterproject_2;

import com.example.apitesterproject_2.uploadingfiles.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiTesterProject2Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiTesterProject2Application.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

}






