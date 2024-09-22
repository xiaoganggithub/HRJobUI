package com.zg.hrjob_server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api.url")
public class ApiUrlConfig {
    private String floorLayout;
    private String workOrders;
    private String preciseWorkOrders;

    // Getters and setters
    public String getFloorLayout() {
        return floorLayout;
    }

    public void setFloorLayout(String floorLayout) {
        this.floorLayout = floorLayout;
    }

    public String getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(String workOrders) {
        this.workOrders = workOrders;
    }

    public String getPreciseWorkOrders() {
        return preciseWorkOrders;
    }

    public void setPreciseWorkOrders(String preciseWorkOrders) {
        this.preciseWorkOrders = preciseWorkOrders;
    }
}