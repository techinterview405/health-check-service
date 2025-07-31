package com.generic.showcase.healthcheck_monitoring_service.domain.manager.runresult;

import com.generic.showcase.healthcheck_monitoring_service.domain.model.HealthCheckRunResponse;
import com.generic.showcase.healthcheck_monitoring_service.domain.model.entity.RunResultEntity;
import com.generic.showcase.healthcheck_monitoring_service.domain.model.RunResultHealth;
import com.generic.showcase.healthcheck_monitoring_service.domain.repository.RunResultRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class RunResultManagerImpl implements RunResultManager {

    private RunResultRepository runResultRepository;

    @Autowired
    public RunResultManagerImpl(RunResultRepository runResultRepository) {
        this.runResultRepository = runResultRepository;
    }

    @Override
    public void logRunResult(HealthCheckRunResponse response, RunResultHealth health) {
        RunResultEntity runResultEntity = new RunResultEntity(response.getHealthCheckId(), response.getUrl(), response.getHttpStatusCode(), response.getResponseBody(), response.getErrorMessage(), health);
        this.runResultRepository.save(runResultEntity);
        log.info("RunResultManagerImpl - Logging run result for healthCheckId {}, statusCode {}", response.getHealthCheckId(), response.getHttpStatusCode());
    }

    @Override
    public List<RunResultEntity> getResultsByHealthCheckId(String healthCheckId) {
        return this.runResultRepository.findAllByHealthCheckId(healthCheckId);
    }
}
