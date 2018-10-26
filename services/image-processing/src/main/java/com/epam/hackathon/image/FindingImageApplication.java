package com.epam.hackathon.image;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableScheduling
public class FindingImageApplication {


    @Bean
    AmazonRekognition amazonRekognition(@Value("${access.key}") final String accessKey,
                                        @Value("${secret.key}") final String secretKey,
                                        @Value("${region}") final String region) {
        ClientConfiguration config = new ClientConfiguration();
        config.setConnectionTimeout(140000);
        config.setRequestTimeout(170000);
        config.setProtocol(Protocol.HTTPS);

        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(credentials);

        return AmazonRekognitionClientBuilder.standard()
                .withClientConfiguration(config)
                .withCredentials(credentialsProvider)
                .withRegion(region).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(FindingImageApplication.class, args);
    }
}
