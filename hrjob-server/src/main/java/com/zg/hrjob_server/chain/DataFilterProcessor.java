package com.zg.hrjob_server.chain;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DataFilterProcessor extends DataProcessor {
    @Override
    public void process(DataContext context) {
        // 过滤隐藏楼层
        context.setFloorLayout(context.getFloorLayout().stream()
                .filter(floor -> !context.getHiddenFloorCodes().contains(floor.get("floorCode")))
                .collect(Collectors.toList()));

        if (nextProcessor != null) {
            nextProcessor.process(context);
        }
    }
}