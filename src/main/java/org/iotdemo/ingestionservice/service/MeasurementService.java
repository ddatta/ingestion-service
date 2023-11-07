package org.iotdemo.ingestionservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.iotdemo.ingestionservice.dto.MeasurementRequest;
import org.iotdemo.ingestionservice.dto.MeasurementResponse;
import org.iotdemo.ingestionservice.model.Measurement;
import org.iotdemo.ingestionservice.repository.MeasurementRepository;

import java.util.List;

@Service
@Slf4j
public class MeasurementService {


    @Autowired
    private final MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository){
            this.measurementRepository = measurementRepository;
        }

    public void createMeasurement(MeasurementRequest request){
        Measurement measurement = Measurement.builder()
                .vehicleId(request.getVehicleId())
                .build();

        measurementRepository.save(measurement);
        log.info("Product {} is saved", measurement.getId());
    }

    public List<MeasurementResponse> getAllMeasurements(){
        List<Measurement> measurements =  measurementRepository.findAll();
        return measurements.stream().map(product -> mapToProductResponse(product)).toList();

    }

    private MeasurementResponse mapToProductResponse(Measurement measurement){
        return MeasurementResponse.builder()
                .id(measurement.getId())
                .vehicleId(measurement.getVehicleId())
                .build();
    }
}
