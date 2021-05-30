package com.koushik.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koushik.batch.model.SalesRecords;

@Repository
public interface SalesRecordsRepository extends JpaRepository<SalesRecords, Long> {

}
