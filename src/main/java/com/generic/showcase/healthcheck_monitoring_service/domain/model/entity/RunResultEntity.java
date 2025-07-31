package com.generic.showcase.healthcheck_monitoring_service.domain.model.entity;

import com.generic.showcase.healthcheck_monitoring_service.domain.model.RunResultHealth;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="RUN_RESULT")
@AllArgsConstructor
public class RunResultEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "RUN_RESULT_ID")
    private String runResultID;

    @Column(name = "HEALTHCHECK_ID")
    private String healthCheckId;

    @Column(name = "REQUEST_URL")
    private String url;

    @Column(name = "HTTP_STATUS_CODE")
    private Integer httpStatusCode;

    @Column(name = "RESPONSE_BODY")
    private String responseBody;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;

    @Enumerated(EnumType.ORDINAL)
    private RunResultHealth health;

    public RunResultEntity(){}

    public RunResultEntity(String healthCheckId, String url, Integer httpStatusCode, String responseBody, String errorMessage, RunResultHealth health) {
        this.healthCheckId = healthCheckId;
        this.url = url;
        this.httpStatusCode = httpStatusCode;
        this.responseBody = responseBody;
        this.errorMessage = errorMessage;
        this.health = health;
    }
}
