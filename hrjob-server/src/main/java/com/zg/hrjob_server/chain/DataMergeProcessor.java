package com.zg.hrjob_server.chain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataMergeProcessor extends DataProcessor {
    @Override
    public void process(DataContext context) {
        List<Map<String, Object>> mergedData = new ArrayList<>();

        for (Map<String, Object> floor : context.getFloorLayout()) {
            Map<String, Object> floorData = new HashMap<>(floor);
            List<Map<String, Object>> floorWorkOrders = context.getWorkOrders().stream()
                    .filter(wo -> wo.get("floorCode").equals(floor.get("floorCode")))
                    .toList();
            floorData.put("workOrders", floorWorkOrders);
            mergedData.add(floorData);
        }

        context.setMergedData(mergedData);

        if (nextProcessor != null) {
            nextProcessor.process(context);
        }
    }
}