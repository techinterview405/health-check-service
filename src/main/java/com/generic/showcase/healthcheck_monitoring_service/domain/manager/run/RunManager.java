package com.generic.showcase.healthcheck_monitoring_service.domain.manager.run;

import com.generic.showcase.healthcheck_monitoring_service.api.model.RunStateEnum;

public interface RunManager {

    boolean stopRunManager();

    boolean startRunManager();

    RunStateEnum getRunState();
}
