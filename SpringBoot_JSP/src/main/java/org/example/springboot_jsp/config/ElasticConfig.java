package org.example.springboot_jsp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "org.example.springboot_jsp.repository.elastic")
public class ElasticConfig {
}
