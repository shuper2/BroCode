package com.epam.hackathon.image.face;

import com.epam.hackathon.image.FindingImageApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FindingImageApplication.class)
public class SearchFaceTest {

    @Autowired
    private SearchFace searchFace;

    @Test
    public void compareImages(){
        String folderLocationToSearch="C:\\Users\\Hp\\Pictures\\test\\2";
        String sourceImage="C:\\Users\\Hp\\Pictures\\test\\devendra.jpg";

        searchFace.setSimilarityThreshold(55f);
      //  Map<String, Float> matchedImages=searchFace.run(folderLocationToSearch, sourceImage);


        System.out.println("DONE");
    }
}