package com.epam.hackathon.image.client;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.epam.hackathon.image.util.FileUtil;

public class ClientFactory {
	
	/***
	 * This static method creates client for AMAZON REKOGNITION service. 
	 * @return
	 */
	public static AmazonRekognition createClient() {
		ClientConfiguration config=new ClientConfiguration();
		config.setConnectionTimeout(140000);
		config.setRequestTimeout(170000);
		config.setProtocol(Protocol.HTTPS);
		
		String accessKey=FileUtil.getValueFromResourceBundle("access.key");
		String secretKey=FileUtil.getValueFromResourceBundle("secret.key");
		String region=FileUtil.getValueFromResourceBundle("region");
		BasicAWSCredentials credentials=new BasicAWSCredentials(accessKey, secretKey);
		AWSStaticCredentialsProvider credentialsProvider=new AWSStaticCredentialsProvider(credentials);
		
		return AmazonRekognitionClientBuilder.standard().withClientConfiguration(config).withCredentials(credentialsProvider)
				.withRegion(region).build();
		
	}
}
