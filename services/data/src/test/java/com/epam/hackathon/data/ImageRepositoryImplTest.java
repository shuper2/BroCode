package com.epam.hackathon.data;

import com.epam.hachathon.domain.FoundImage;
import com.epam.hachathon.domain.LostImage;
import com.epam.hackathon.config.MongoDBConfig;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoDBConfig.class, ImageRepositoryImpl.class})
public class ImageRepositoryImplTest extends TestCase {

    @Autowired
    ImageRepositoryImpl imageRepository;

    @Test
    public void findAllLostImages() {
        List<LostImage> lostImages = imageRepository.findAllLostImages();
        for (LostImage lostImage : lostImages) {
            System.out.println("====================================");
            System.out.println("Lost Image Id : " + lostImage.getLostImageId());
            System.out.println("Lost Image Path : " + lostImage.getLostImagePath());
            for (FoundImage foundImage : lostImage.getFoundImages()) {
                System.out.println("----------------------------------");
                System.out.println("    Found Image Id : " + foundImage.getFoundImageId());
                System.out.println("    Found Image Path : " + foundImage.getFoundImagePath());
                System.out.println("    Found Image Percentage : " + foundImage.getMatchPercentage());
                System.out.println("----------------------------------");
            }
            System.out.println("====================================");
        }
    }

}
