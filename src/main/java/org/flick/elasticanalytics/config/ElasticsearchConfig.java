package org.flick.elasticanalytics.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableElasticsearchRepositories(basePackages = "org.flick.elasticanalytics.repository")
@ComponentScan(basePackages = {"org.flick.elasticanalytics.repository"})
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
    @Value("${spring.elasticsearch.rest.uris}")
    String url;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

}
