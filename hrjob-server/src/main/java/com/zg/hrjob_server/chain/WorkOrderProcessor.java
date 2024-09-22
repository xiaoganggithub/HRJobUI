package com.zg.hrjob_server.chain;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WorkOrderProcessor extends DataProcessor {
    private final RestTemplate restTemplate;

    public WorkOrderProcessor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void process(DataContext context) {
        // 调用API获取工单数据
        List<Map<String, Object>> workOrders = restTemplate.getForObject("http://api.example.com/work-orders", List.class);
        context.setWorkOrders(workOrders);

        if (nextProcessor != null) {
            nextProcessor.process(context);
        }
    }
}