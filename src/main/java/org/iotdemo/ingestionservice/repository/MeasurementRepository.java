package org.iotdemo.ingestionservice.repository;

import org.iotdemo.ingestionservice.model.Measurement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends MongoRepository<Measurement, String>{
}
