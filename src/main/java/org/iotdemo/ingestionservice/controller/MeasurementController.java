package org.iotdemo.ingestionservice.controller;

import lombok.RequiredArgsConstructor;
import org.iotdemo.ingestionservice.dto.MeasurementRequest;
import org.iotdemo.ingestionservice.dto.MeasurementResponse;
import org.iotdemo.ingestionservice.service.MeasurementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;
    @PostMapping("/measurement")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMethod(@RequestBody MeasurementRequest measurementRequest){
        measurementService.createMeasurement(measurementRequest);

    }

    @GetMapping("/measurements")
    @ResponseStatus(HttpStatus.OK)
    public List<MeasurementResponse> getAllMeasurements(){
       return measurementService.getAllMeasurements();

    }


}
