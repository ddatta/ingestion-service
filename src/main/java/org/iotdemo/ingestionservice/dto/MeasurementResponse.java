package org.iotdemo.ingestionservice.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementResponse {

    @Id
    private String id;
    private String vehicleId;

}
