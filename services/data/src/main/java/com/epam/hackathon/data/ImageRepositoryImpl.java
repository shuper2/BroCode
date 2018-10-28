package com.epam.hackathon.data;

import com.epam.hackathon.domain.LostImage;
import com.epam.hackathon.config.MongoDBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageRepositoryImpl implements ImageRepository {

    private MongoDBConfig dataSource;

    @Autowired
    public ImageRepositoryImpl(MongoDBConfig dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<LostImage> findAllLostImages() {
        return dataSource.getDataSource().find(LostImage.class).asList();
    }
    @Override
    public void insert(List<LostImage> lostImages) {
        dataSource.getDataSource().save(lostImages);
    }

    @Override
    public LostImage getLostImageById(int lostImageId){
        return dataSource.getDataSource().find(LostImage.class).field("lostImageId").equal(lostImageId).get();
    }
}
