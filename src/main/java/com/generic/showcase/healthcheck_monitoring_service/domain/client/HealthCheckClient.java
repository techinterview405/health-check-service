package com.generic.showcase.healthcheck_monitoring_service.domain.client;

import com.generic.showcase.healthcheck_monitoring_service.domain.model.entity.HealthCheckEntity;
import com.generic.showcase.healthcheck_monitoring_service.domain.model.HealthCheckRunResponse;

public interface HealthCheckClient {

    HealthCheckRunResponse executeHttpRequestAndGetResponse(HealthCheckEntity healthCheckEntity);

}
