package com.koushik.batch.utilities;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.koushik.batch.model.SalesRecords;
import com.koushik.batch.repository.SalesRecordsRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DestinationWriter implements ItemWriter<SalesRecords> {

	@Autowired
	private SalesRecordsRepository salesRecordsRepository;

	@Override
	public void write(List<? extends SalesRecords> salesRecords) throws Exception {
		log.info("Details of the saving data is:" + salesRecords);
		for(SalesRecords salesRecord: salesRecords)
		salesRecordsRepository.save(salesRecord);
	}

}
