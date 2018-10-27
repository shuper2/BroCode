package com.epam.hackathon.web;

import com.epam.hackathon.data.ImageRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FindingWebApplication implements WebMvcConfigurer {

    @Bean
    ImageRepository findingCaseRepository() {
        return new ImageRepository(){};
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/");
    }
    public static void main(String[] args) {
        SpringApplication.run(FindingWebApplication.class, args);
    }
}
