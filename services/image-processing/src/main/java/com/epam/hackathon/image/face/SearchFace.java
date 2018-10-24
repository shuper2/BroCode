package com.epam.hackathon.image.face;

import com.amazonaws.services.rekognition.model.CompareFacesMatch;
import com.epam.hackathon.image.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/***
 * This class is to search for a given face in the images already present in a particular repository.
 *
 */
@Component
public class SearchFace {
    private static final Logger logger = Logger.getLogger(SearchFace.class.getName());

    private final CompareFaces compareFaces;
    private float similarityThreshold; //Threshold % that will be considered as a match

    @Autowired
    public SearchFace(final CompareFaces compareFaces,
                      @Value("${similarity.threshold}") float similarityThreshold) {
        this.compareFaces = compareFaces;
        this.similarityThreshold = similarityThreshold;
    }

    /***
     * This method run the search of face from source image in all the target images in a given repository.
     * @param folderLocationToSearch Our local repository containing all the found images
     * @param sourceImage Image of person who is lost and its the source image that will be searched against the found images.
     * @return A map of image with corresponding similarity confidence value.
     */
    public Map<String, Float> run(String folderLocationToSearch, String sourceImage) {
        //List<String> matchingImages=new ArrayList<>();
        Map<String, Float> matchingImages = new HashMap<String, Float>();

        logger.info("=============>Going to search for face in '" + sourceImage + "' in all the images present at '" + folderLocationToSearch + "'<==============");

        List<String> targetImages = FileUtil.getAllImagesFromFolder(folderLocationToSearch);

        logger.info("Total of " + targetImages.size() + " images found in our target repository : '" + folderLocationToSearch + "'");

        //Iterate over the target images
        for (String targetImage : targetImages) {

            //Compare given source image with the current target image.
            List<CompareFacesMatch> matchedFaces = compareFaces.run(sourceImage, targetImage);

            if (matchedFaces.size() > 0) {

                //Matching found
                logger.info("============>" + matchedFaces.size() + " MATCHING FACE FOUND IN " + targetImage + "<=============");

                //Show matching faces with their similarity confidence value
                Float similarityConfidence = 0f;
                for (CompareFacesMatch faceMatch : matchedFaces) {

                    logger.info("====>Similarity confidence : " + faceMatch.getSimilarity() + "<=====");

                    //if more than 1 face matching with input is found then we will keep the similarityConfidence of highest value.
                    if (faceMatch.getSimilarity() > similarityConfidence) {
                        similarityConfidence = faceMatch.getSimilarity();
                    }
                }
                matchingImages.put(targetImage, similarityConfidence);
                logger.info("----------------------------------------------------");
            } else {

                //Matching not found
                logger.info("xxxxxxxxxxxxxxxxxxxxx MATCH NOT FOUND in '" + targetImage + "' xxxxxxxxxxxxxxxxxxxxxxx");
                logger.info("----------------------------------------------------");
            }
        }

        logger.info(">>>>>Total of " + matchingImages.size() + " matches found.<<<<<<");

        return matchingImages;
    }

    public float getSimilarityThreshold() {
        return similarityThreshold;
    }
    public void setSimilarityThreshold(final float similarityThreshold) {
        this.similarityThreshold = similarityThreshold;
        this.compareFaces.setSimilarityThreshold(similarityThreshold);
    }
}
