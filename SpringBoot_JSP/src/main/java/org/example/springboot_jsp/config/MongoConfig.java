package org.example.springboot_jsp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "org.example.springboot_jsp.repository.mongo")
public class MongoConfig {
}
