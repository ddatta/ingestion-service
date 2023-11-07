package org.iotdemo.ingestionservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document(value="measurement")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Measurement {
    @Id
    private String id;
    private String vehicleId;
}
