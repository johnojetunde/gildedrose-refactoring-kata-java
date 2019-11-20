package com.gildedrose.app.config;

import lombok.extern.java.Log;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log
@Configuration
public class ElasticSearchConfig {

    @Value("${elasticsearch.host:localhost}")
    public String host;

    @Value("${elasticsearch.port:9200}")
    public int port;

    @Bean
    public RestHighLevelClient client() {
        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port));
        return new RestHighLevelClient(builder);
    }


}
