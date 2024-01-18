package com.example.wanderingyak.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(MongoConfig.class);

    @Value("${MONGODB_PREFIX}")
    private String mongodbPrefix;

    @Value("${MONGODB_USERNAME}")
    private String mongodbUsername;

    @Value("${MONGODB_PASSWORD}")
    private String mongodbPassword;

    @Value("${MONGODB_DB}")
    private String mongodbDb;

    @Value("${MONGODB_DB_NAME}")
    private String mongodbDbName;

    @Override
    protected String getDatabaseName() {
        return "wandering_yak";
    }

    @Override
    public MongoClient mongoClient() {
        String uri = mongodbPrefix + "://" + mongodbUsername + ":" + mongodbPassword + "@" + mongodbDb + "/"
                + mongodbDbName;
        logMongoUri(uri);
        return MongoClients.create(uri);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

    private void logMongoUri(String uri) {
        String maskedUri = uri.replaceAll("mongodb+srv://[^:]+:[^@]+@", "mongodb+srv://username:***@");
        logger.info("Connecting to MongoDB with URI: {}", maskedUri);
    }
}
