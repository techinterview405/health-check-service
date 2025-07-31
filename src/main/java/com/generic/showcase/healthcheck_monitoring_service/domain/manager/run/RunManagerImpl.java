package com.generic.showcase.healthcheck_monitoring_service.domain.manager.run;

import com.generic.showcase.healthcheck_monitoring_service.api.model.RunStateEnum;
import com.generic.showcase.healthcheck_monitoring_service.domain.model.entity.HealthCheckEntity;
import com.generic.showcase.healthcheck_monitoring_service.domain.model.HealthCheckRunResponse;
import com.generic.showcase.healthcheck_monitoring_service.domain.model.RunResultHealth;
import com.generic.showcase.healthcheck_monitoring_service.domain.client.HealthCheckClient;
import com.generic.showcase.healthcheck_monitoring_service.domain.manager.healthcheck.HealthCheckManager;
import com.generic.showcase.healthcheck_monitoring_service.domain.manager.runresult.RunResultManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RunManagerImpl implements RunManager{

    private HealthCheckClient healthCheckClient;
    private HealthCheckManager healthCheckManager;
    private RunStateEnum runState;
    private RunResultManager runResultManager;

    @Autowired
    public RunManagerImpl(HealthCheckClient healthCheckClient, HealthCheckManager healthCheckManager, RunResultManager runResultManager) {
        this.healthCheckClient = healthCheckClient;
        this.healthCheckManager = healthCheckManager;
        this.runResultManager = runResultManager;
        this.runState = RunStateEnum.RUNNING;
    }


    @Override
    public boolean stopRunManager() {
        this.runState = RunStateEnum.STOPPED;
        return true;
    }

    @Override
    public boolean startRunManager() {
        this.runState = RunStateEnum.RUNNING;
        return true;
    }

    @Override
    public RunStateEnum getRunState() {
        return this.runState;
    }

    //10 seconds
    @Scheduled(fixedRateString = "${run.fixedRateInMillis}")
    private void run(){

        if (this.runState.equals(RunStateEnum.RUNNING)){
            log.info("Run manager is running...");
            for (HealthCheckEntity healthCheck : this.healthCheckManager.getAllHealthCheckByStatus(true)){
                log.info("Executing health check run for HealthCheck ID {}", healthCheck.getId());

                HealthCheckRunResponse runResponse = this.healthCheckClient.executeHttpRequestAndGetResponse(healthCheck);

                this.runResultManager.logRunResult(runResponse, RunResultHealth.HEALTHY);

            }
        } else {
            log.warn("Run manager at stopped state - not running active HealthChecks.");
        }
    }
}
