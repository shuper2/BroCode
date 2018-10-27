package com.epam.hackathon.data;

import com.epam.hachathon.domain.LostImage;
import com.epam.hackathon.config.MongoDBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageRepositoryImpl implements ImageRepository {

    private MongoDBConfig mongoDBConfig;

    @Autowired
    public ImageRepositoryImpl(MongoDBConfig mongoDBConfig) {
        this.mongoDBConfig = mongoDBConfig;
    }

    public List<LostImage> findAllLostImages() {

        return mongoDBConfig.getDataSource().find(LostImage.class).asList();
    }

    public void insert(List<LostImage> lostImages) {
        mongoDBConfig.getDataSource().save(lostImages);
    }
}
