package com.fpoly.assignmentjava6;

import com.fpoly.assignmentjava6.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssignmentJava6Application {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentJava6Application.class, args);
    }
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.init();
        };
    }
}
