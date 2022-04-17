package com.ask.solutions.elastic.controller;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ask.solutions.elastic.responsemodel.ApiResponse;
import com.ask.solutions.elastic.service.ElasticService;

@RestController
public class ESController implements IESController {
	
	@Autowired
	ElasticService esService;
	
	@Autowired
	RestHighLevelClient client;
	
	@Override
	public ApiResponse<String> getBookingDetails() {
		ApiResponse<String> response = new ApiResponse<>();
		response.setStatus(HttpStatus.OK);
		response.setMessage("Retrieving records for the match all query from elastic sarch");
		response.setData(esService.getEsResponseFromMatchAllQuery(client));
		return response;
	}

	@Override
	public ApiResponse<String> getBankDetaiilsByFirstName(String name) {
		ApiResponse<String> response = new ApiResponse<>();
		response.setStatus(HttpStatus.OK);
		response.setMessage("Retrieving records for the match  query based on firstname from elastic sarch");
		response.setData(esService.getEsResponseFromMatchQuery(client, name));
		return response;
	}

}
