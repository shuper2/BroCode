package com.epam.hackathon.image.face;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class SearchFaceTest {

    @Test
    public void compareImages(){
        String folderLocationToSearch="C:\\Users\\Hp\\Pictures\\test\\2";
        String sourceImage="C:\\Users\\Hp\\Pictures\\test\\devendra.jpg";
        float similarityThreshold=55f;

        SearchFace searchFace=new SearchFace(folderLocationToSearch, sourceImage, similarityThreshold);
        Map<String, Float> matchedImages=searchFace.run();


        System.out.println("DONE");
    }
}