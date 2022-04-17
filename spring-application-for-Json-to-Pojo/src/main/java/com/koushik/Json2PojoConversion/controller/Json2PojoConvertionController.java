package com.koushik.Json2PojoConversion.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koushik.Json2PojoConversion.response.ApiResponse;
import com.koushik.Json2PojoConversion.service.Json2PojoConvertionService;

@RestController
public class Json2PojoConvertionController {
	
	@Autowired
	Json2PojoConvertionService json2PojoConvertionService;
	
	@PostMapping("/Json2Pojo")
	public ApiResponse<String> getPojoFromJsonGiven(@RequestBody String inputPath) throws IOException {
		ApiResponse<String> response = new ApiResponse<>();
		response.setStatus(HttpStatus.OK);
		response.setMessage("Retrieving records for the match all query from elastic sarch");
		response.setData(json2PojoConvertionService.getPojoFromJson(inputPath));
		return response;
	}

}
