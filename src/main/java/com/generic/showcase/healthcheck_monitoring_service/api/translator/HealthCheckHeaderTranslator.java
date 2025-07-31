package com.generic.showcase.healthcheck_monitoring_service.api.translator;

import com.generic.showcase.healthcheck_monitoring_service.api.model.KeyValuePair;
import com.generic.showcase.healthcheck_monitoring_service.domain.model.entity.HealthCheckHeaderEntity;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckHeaderTranslator extends Translator <KeyValuePair, HealthCheckHeaderEntity>{

    @Override
    public KeyValuePair toApiModel(HealthCheckHeaderEntity domain) {

        KeyValuePair keyValuePair = new KeyValuePair();
        keyValuePair.setId(domain.getHeaderID());
        keyValuePair.setKey(domain.getHeaderName());
        keyValuePair.setValue(domain.getHeaderValue());
        return keyValuePair;
    }

    @Override
    public HealthCheckHeaderEntity toDomainModel(KeyValuePair api) {

        HealthCheckHeaderEntity healthCheckHeaderEntity = new HealthCheckHeaderEntity();
        healthCheckHeaderEntity.setHeaderID(api.getId());
        healthCheckHeaderEntity.setHeaderName(api.getKey());
        healthCheckHeaderEntity.setHeaderValue(api.getValue());
        return healthCheckHeaderEntity;
    }
}
