package org.iotdemo.ingestionservice.service;

import lombok.RequiredArgsConstructor;
import org.iotdemo.ingestionservice.dto.MeasurementRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MessageConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaProperties.Consumer.class);

    private final MeasurementService measurementService;
    @KafkaListener(topics = "iotdemotopic", groupId = "ingestion")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        System.out.println("############### This came in ");
        System.out.println(message);
        measurementService.createMeasurement(new MeasurementRequest(message));
        System.out.println("############### End ");

    }
}

