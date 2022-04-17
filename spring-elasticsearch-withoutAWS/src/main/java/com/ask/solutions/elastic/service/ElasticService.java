package com.ask.solutions.elastic.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WrapperQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ElasticService {
	
	public String getEsResponseFromMatchAllQuery(RestHighLevelClient client) {
		SearchRequest searchRequest = new SearchRequest();
	    searchRequest.indices("bank");
	    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	    searchSourceBuilder.query(QueryBuilders.matchAllQuery());
	    searchSourceBuilder.size(300);
	    searchRequest.source(searchSourceBuilder);
	    Map<String, Object> map=null;
	    String response = "";
	     
	    try {
	        SearchResponse searchResponse = null;
	        searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
	        if (searchResponse.getHits().getTotalHits().value > 0) {
	            SearchHit[] searchHit = searchResponse.getHits().getHits();
	            for (SearchHit hit : searchHit) {
	                map = hit.getSourceAsMap();
	               response = response.concat(Arrays.toString(map.entrySet().toArray()));    
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return response;
	}
	
	public String getEsResponseFromMatchQuery(RestHighLevelClient client, String matchingString) {
		
		SearchRequest searchRequest = new SearchRequest();
	    searchRequest.indices("bank");
	    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	    searchSourceBuilder.query(QueryBuilders.matchQuery("firstname", matchingString));
	    searchSourceBuilder.size(300);
	    searchRequest.source(searchSourceBuilder);
	    Map<String, Object> map=null;
	    String response = "";
	     
	    try {
	        SearchResponse searchResponse = null;
	        searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
	        System.out.println(searchResponse.toString());
	        if (searchResponse.getHits().getTotalHits().value > 0) {
	            SearchHit[] searchHit = searchResponse.getHits().getHits();
	            for (SearchHit hit : searchHit) {
	                map = hit.getSourceAsMap();
	               response = response.concat(Arrays.toString(map.entrySet().toArray()));   
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return response;
		
	}
	
public String getEsResponseForCustomQuery(RestHighLevelClient client, JsonNode customQuery) {
		
		SearchRequest searchRequest = new SearchRequest();
	    searchRequest.indices("bank");
	    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	    WrapperQueryBuilder searchQuery = new WrapperQueryBuilder(customQuery.get("query").toString());
	    searchSourceBuilder.query(searchQuery);
	    searchSourceBuilder.size(300);
	    searchRequest.source(searchSourceBuilder);
	    Map<String, Object> map=null;
	    String response = "";
	     
	    try {
	        SearchResponse searchResponse = null;
	        searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
	        System.out.println(searchResponse.toString());
	        if (searchResponse.getHits().getTotalHits().value > 0) {
	            SearchHit[] searchHit = searchResponse.getHits().getHits();
	            for (SearchHit hit : searchHit) {
	                map = hit.getSourceAsMap();
	               response = response.concat(Arrays.toString(map.entrySet().toArray()));   
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return response;
		
	}

}
