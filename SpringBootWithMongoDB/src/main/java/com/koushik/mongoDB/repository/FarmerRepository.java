package com.koushik.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.koushik.mongoDB.model.Farmer;

@Repository
public interface FarmerRepository extends MongoRepository<Farmer, Integer> {

}
