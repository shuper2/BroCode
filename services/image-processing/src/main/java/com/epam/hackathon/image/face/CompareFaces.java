package com.epam.hackathon.image.face;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.model.CompareFacesMatch;
import com.amazonaws.services.rekognition.model.CompareFacesRequest;
import com.amazonaws.services.rekognition.model.CompareFacesResult;
import com.amazonaws.services.rekognition.model.Image;
import com.epam.hackathon.image.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.logging.Logger;

/***
 * This class have methods that will take face from source image and will check if similar face is present in target image or not.
 * There is a similarity threshold value that will be used to decide whether the face matches or not.
 *
 */
@Component
public class CompareFaces {

    private static final Logger logger = Logger.getLogger(CompareFaces.class.getName());

    private final AmazonRekognition awsClient;
    private float similarityThreshold;

    @Autowired
    public CompareFaces(final AmazonRekognition awsClient,
                        @Value("${similarity.threshold}") float similarityThreshold) {
        this.awsClient = awsClient;
        this.similarityThreshold = similarityThreshold;
    }

    /***
     * This method call the AWS api to compare face from source image in target image with the given similrity confidence value.
     * @return
     */
    public List<CompareFacesMatch> run(String sourceImage, String targetImage) {
        ByteBuffer source = FileUtil.loadImage(sourceImage);
        ByteBuffer target = FileUtil.loadImage(targetImage);

        if (source == null || target == null) {
            logger.warning("None of the image (source/target) should be null. Source Image : " + sourceImage + " Target Image : " + targetImage);
            return null;
        }

        logger.info("Comparing Source Image : " + sourceImage + " with target image : " + targetImage);

        CompareFacesRequest request = new CompareFacesRequest().withSourceImage(new Image().withBytes(source)).withTargetImage(new Image().withBytes(target))
                .withSimilarityThreshold(similarityThreshold);

        CompareFacesResult result = awsClient.compareFaces(request);
        List<CompareFacesMatch> faceMatches = result.getFaceMatches();

        return faceMatches;
    }

    public AmazonRekognition getAwsClient() {
        return awsClient;
    }
    public float getSimilarityThreshold() {
        return similarityThreshold;
    }
    public void setSimilarityThreshold(final float similarityThreshold) {
        this.similarityThreshold = similarityThreshold;
    }
}
