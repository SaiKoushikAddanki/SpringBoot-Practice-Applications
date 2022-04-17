package com.koushik.Json2PojoConversion.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sun.codemodel.JCodeModel;

@Service
public class Json2PojoConvertionService {

	Logger logger = LoggerFactory.getLogger(Json2PojoConvertionService.class);

	public String getPojoFromJson(String inputPath) throws IOException {
		logger.info("The input file path is:{} ", inputPath);
		String packageName = "app.converted.pojo";
		File inputJson = new File(inputPath);
		logger.info("Input file in bytes is: {}", inputJson.exists());
		File outputDirectory = new File("." + File.separator + "pojoFolder");
		logger.info("Output directory creation: {}", outputDirectory.mkdirs());
		JCodeModel codeModel = new JCodeModel();
		try {
			URL source = inputJson.toURI().toURL();
			GenerationConfig config = new DefaultGenerationConfig() {
				@Override
				public SourceType getSourceType() {
					return SourceType.JSON;
				}
			};
			SchemaMapper mapper = new SchemaMapper(
					new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
			mapper.generate(codeModel, inputJson.getName().replace(".json", ""), packageName, source);
			codeModel.build(outputDirectory);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Encountered a generic exception.");
			e.printStackTrace();
		}
		return "Successfully comnpleted the pojo convertion";
	}
}
