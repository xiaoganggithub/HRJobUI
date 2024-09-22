package com.zg.hrjob_server.chain;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class WorkOrderPriorityProcessor extends DataProcessor {
    @Override
    public void process(DataContext context) {
        List<Map<String, Object>> allWorkOrders = Stream.concat(
                context.getPreciseWorkOrders().stream(),
                context.getWorkOrders().stream()
        ).collect(Collectors.toList());

        // 根据优先级排序工单
        allWorkOrders.sort(Comparator.comparingInt(wo -> (int) wo.get("priority")));

        context.setWorkOrders(allWorkOrders);

        if (nextProcessor != null) {
            nextProcessor.process(context);
        }
    }
}