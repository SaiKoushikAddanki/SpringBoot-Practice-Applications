package com.ask.solutions.elastic.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EsConfig {

	@Bean
	public RestHighLevelClient getRestClient() {
		return new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
	}
}
