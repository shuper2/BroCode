package com.epam.hackathon.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBConfig {

    @Bean(name = "dataSource")
    public Datastore getDataSource() {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://testuser:testpassword@brocode-i63ag.mongodb.net");

        MongoClient mongoClient = new MongoClient(uri);
        Morphia morphia = new Morphia();
        Datastore dataStore = morphia.createDatastore(mongoClient, "MyDataBase");
        return dataStore;
    }
}
