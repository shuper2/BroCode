package com.epam.hackathon.web;

import com.epam.hackathon.data.CaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FindingWebApplication {

    @Bean
    CaseRepository findingCaseRepository() {
        throw new AssertionError("Not implemented");
    }

    public static void main(String[] args) {
        SpringApplication.run(FindingWebApplication.class, args);
    }
}
