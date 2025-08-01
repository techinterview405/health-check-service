@echo off
java -Dspring.profiles.active=mode1 -jar ./endpoint-app/health-check-test.jar
pause >nul