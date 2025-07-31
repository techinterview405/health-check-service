package com.generic.showcase.healthcheck_monitoring_service.api.controller;

import com.generic.showcase.healthcheck_monitoring_service.domain.manager.runresult.RunResultManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Run Result Controller", description = "Controller for managing run results of health checks")
@RestController
@RequestMapping(value = "/runResult")
public class RunResultController {

    private RunResultManager runResultManager;

    @Autowired
    public RunResultController(RunResultManager runResultManager) {
        this.runResultManager = runResultManager;
    }

    @Operation(summary = "Get Run Results for Health Check by ID")
    @GetMapping(value = "/all/{id}")
    public ResponseEntity startRun(@PathVariable String id){
        return ResponseEntity.ok(this.runResultManager.getResultsByHealthCheckId(id));
    }
}
