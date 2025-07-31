package com.generic.showcase.healthcheck_monitoring_service.api.controller;

import com.generic.showcase.healthcheck_monitoring_service.domain.manager.run.RunManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Run Manager Controller", description = "Controller for managing the run state of the health check monitoring service")
@RestController
@RequestMapping(value = "/runManager")
public class RunManagerController {

    private RunManager runManager;

    @Autowired
    public RunManagerController(RunManager runManager) {
        this.runManager = runManager;
    }

    @Operation(summary = "Get Run Status")
    @GetMapping
    public ResponseEntity getRunStatus(){
        return ResponseEntity.ok(this.runManager.getRunState());
    }

    @Operation(summary = "Start Run")
    @PostMapping(value = "/start")
    public ResponseEntity startRun(){
        return ResponseEntity.ok(this.runManager.startRunManager());
    }

    @Operation(summary = "Stop Run")
    @PostMapping(value = "/stop")
    public ResponseEntity stopRun(){
        return ResponseEntity.ok(this.runManager.stopRunManager());
    }

}
