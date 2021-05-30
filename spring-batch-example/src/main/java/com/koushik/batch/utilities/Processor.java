package com.koushik.batch.utilities;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.koushik.batch.model.SalesRecords;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Processor implements ItemProcessor<SalesRecords, SalesRecords> {

	private static final Map<String, String> priorityMap = new HashMap<>();

	static {
		priorityMap.put("H", "HIGH");
		priorityMap.put("C", "CRITICAL");
		priorityMap.put("M", "MEDIUM");
		priorityMap.put("L", "LOW");
	}

	@Override
	public SalesRecords process(SalesRecords salesRecords) throws Exception {
		String priorityCode = salesRecords.getOrderPriority();
		log.info("The priority of the object is: " + priorityCode);
		salesRecords.setOrderPriority(priorityMap.get(priorityCode));
		log.info("The converted priority string is: " + salesRecords.getOrderPriority());
		return salesRecords;
	}

}
