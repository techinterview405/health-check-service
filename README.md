# health-check-monitoring-service

Brief service purpose: At its core, the Monitoring Service provides the ability to manage (CRUD) HTTP request entities, what are called HealthChecks, that are then regularly executed at a scheduled interval.  Executing an HTTP HealthCheck generates a Run Result.  A Run Result captures the HealthCheck ID, the run URL, the return status code, the response body, and the error message if applicable.  Over time, if a HealthCheck's health is consistently unhealthy, per multiple Run Results, an Alert might be created to raise visibility (not yet implemented).

The below image is a quick view of the intended high-level project components.

![image](https://github.com/user-attachments/assets/39baceac-d1ed-48f1-8a6d-7555a24d0314)
