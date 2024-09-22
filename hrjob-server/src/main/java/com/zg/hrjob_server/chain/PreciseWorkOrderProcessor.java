package com.zg.hrjob_server.chain;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PreciseWorkOrderProcessor extends DataProcessor {
    private final RestTemplate restTemplate;

    public PreciseWorkOrderProcessor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void process(DataContext context) {
        // 调用API获取精准工单数据
        List<Map<String, Object>> preciseWorkOrders = restTemplate.getForObject("http://api.example.com/precise-work-orders", List.class);
        context.setPreciseWorkOrders(preciseWorkOrders);

        if (nextProcessor != null) {
            nextProcessor.process(context);
        }
    }
}