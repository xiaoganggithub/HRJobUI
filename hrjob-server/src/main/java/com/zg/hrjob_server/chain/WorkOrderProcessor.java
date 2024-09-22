package com.zg.hrjob_server.chain;

import com.zg.hrjob_server.config.ApiUrlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class WorkOrderProcessor extends DataProcessor {
    private final RestTemplate restTemplate;
    private final ApiUrlConfig apiUrlConfig;

    @Autowired
    public WorkOrderProcessor(RestTemplate restTemplate, ApiUrlConfig apiUrlConfig) {
        this.restTemplate = restTemplate;
        this.apiUrlConfig = apiUrlConfig;
    }

    @Override
    public void process(DataContext context) {
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                apiUrlConfig.getWorkOrders(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {}
        );
        context.setWorkOrders(response.getBody());

        if (nextProcessor != null) {
            nextProcessor.process(context);
        }
    }
}