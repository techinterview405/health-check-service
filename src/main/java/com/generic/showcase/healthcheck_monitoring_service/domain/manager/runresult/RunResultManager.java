package com.generic.showcase.healthcheck_monitoring_service.domain.manager.runresult;

import com.generic.showcase.healthcheck_monitoring_service.domain.model.HealthCheckRunResponse;
import com.generic.showcase.healthcheck_monitoring_service.domain.model.entity.RunResultEntity;
import com.generic.showcase.healthcheck_monitoring_service.domain.model.RunResultHealth;

import java.util.List;

public interface RunResultManager {

    void logRunResult(HealthCheckRunResponse healthCheckRunResponse, RunResultHealth health);

    List<RunResultEntity> getResultsByHealthCheckId(String healthCheckId);

}
