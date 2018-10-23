package com.epam.hackathon.image.face;

import com.amazonaws.services.rekognition.model.CompareFacesMatch;
import com.amazonaws.services.rekognition.model.CompareFacesRequest;
import com.amazonaws.services.rekognition.model.CompareFacesResult;
import com.amazonaws.services.rekognition.model.Image;
import com.epam.hackathon.image.util.FileUtil;
import com.epam.hackathon.image.client.ClientFactory;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.logging.Logger;


/***
 * This class have methods that will take face from source image and will check if similar face is present in target image or not.
 * There is a similarity threshold value that will be used to decide whether the face matches or not.
 * 
 */
public class CompareFaces {
	
	private static Logger logger=Logger.getLogger(CompareFaces.class.getName());
	
	private String sourceImage;
	private String targetImage;
	private float similarityThreshold;
	
	public CompareFaces(String sourceImage, String targetImage, float similarityThreshold) {
		this.sourceImage = sourceImage;
		this.targetImage = targetImage;
		this.similarityThreshold = similarityThreshold;
	}

	public CompareFaces(String sourceImage, String targetImage) {
		this.sourceImage = sourceImage;
		this.targetImage = targetImage;
		similarityThreshold=51f;
	}

	/***
	 * This method call the AWS api to compare face from source image in target image with the given similrity confidence value.
	 * @return
	 */
	public List<CompareFacesMatch> run() {
		ByteBuffer source=FileUtil.loadImage(sourceImage);
		ByteBuffer target=FileUtil.loadImage(targetImage);
		
		if(source==null||target==null) {
			logger.warning("None of the image (source/target) should be null. Source Image : "+sourceImage+" Target Image : "+targetImage);
			return null;
		}
		
		logger.info("Comparing Source Image : "+sourceImage+" with target image : "+targetImage);
		
		CompareFacesRequest request=new CompareFacesRequest().withSourceImage(new Image().withBytes(source)).withTargetImage(new Image().withBytes(target))
				.withSimilarityThreshold(similarityThreshold);
		
		CompareFacesResult result=ClientFactory.createClient().compareFaces(request);
		List<CompareFacesMatch> faceMatches=result.getFaceMatches();

		return faceMatches;
	}
	
	
	public String getSourceImage() {
		return sourceImage;
	}

	public void setSourceImage(String sourceImage) {
		this.sourceImage = sourceImage;
	}

	public String getTargetImage() {
		return targetImage;
	}

	public void setTargetImage(String targetImage) {
		this.targetImage = targetImage;
	}
	
	public float getSimilarityThreshold() {
		return similarityThreshold;
	}

	public void setSimilarityThreshold(float similarityThreshold) {
		this.similarityThreshold = similarityThreshold;
	}
	
}
