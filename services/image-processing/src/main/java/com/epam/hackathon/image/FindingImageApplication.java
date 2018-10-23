package com.epam.hackathon.image;

import com.epam.hackathon.data.CaseRepository;
import com.epam.hackathon.data.MatchRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FindingImageApplication {

    @Bean
    CaseRepository findingCaseRepository() {
        throw new AssertionError("Not implemented");
    }

    @Bean
    MatchRepository matchRepository() {
        throw new AssertionError("Not implemented");
    }

    @Bean
    ImageMatchingApi imageMatchingApi() {
        throw new AssertionError("Not implemented");
    }

    public static void main(String[] args) {
        SpringApplication.run(FindingImageApplication.class, args);
    }
}
