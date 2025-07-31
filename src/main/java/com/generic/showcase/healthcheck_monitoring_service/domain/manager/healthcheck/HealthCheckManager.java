package com.generic.showcase.healthcheck_monitoring_service.domain.manager.healthcheck;

import com.generic.showcase.healthcheck_monitoring_service.domain.model.entity.HealthCheckEntity;

import java.util.List;

public interface HealthCheckManager {

    HealthCheckEntity getHealtCheckByID(String id);

    HealthCheckEntity createHealthCheck(HealthCheckEntity healthCheckEntity);

    HealthCheckEntity updateHealthCheck(HealthCheckEntity healthCheckEntity);

    boolean deleteHealthCheckById(String id);

    List<HealthCheckEntity> getAllHealthCheckByStatus(boolean isActive);

}
