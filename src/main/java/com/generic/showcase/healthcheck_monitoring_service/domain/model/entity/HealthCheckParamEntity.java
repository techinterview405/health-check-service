package com.generic.showcase.healthcheck_monitoring_service.domain.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="HEALTHCHECK_PARAM")
public class HealthCheckParamEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "PARAM_ID")
    private String paramID;

    @Column
    private String paramName;

    @Column
    private String paramValue;

}
