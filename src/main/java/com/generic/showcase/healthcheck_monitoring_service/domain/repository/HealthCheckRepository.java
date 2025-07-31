package com.generic.showcase.healthcheck_monitoring_service.domain.repository;

import com.generic.showcase.healthcheck_monitoring_service.domain.model.entity.HealthCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HealthCheckRepository extends JpaRepository<HealthCheckEntity, String> {

    @Query(value = "SELECT * FROM HEALTHCHECK hc WHERE hc.active = ?1", nativeQuery = true)
    List<HealthCheckEntity> findByActiveTrue(boolean isActive);
}
