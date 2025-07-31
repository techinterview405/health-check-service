package com.generic.showcase.healthcheck_monitoring_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class HealthCheckRunResponse {

    private String healthCheckId;
    private String url;
    private Integer httpStatusCode;
    private String responseBody;
    private String errorMessage;

}
