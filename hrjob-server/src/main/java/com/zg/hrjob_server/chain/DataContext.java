package com.zg.hrjob_server.chain;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class DataContext {
    private List<Map<String, Object>> floorLayout;
    private List<Map<String, Object>> workOrders;
    private List<Map<String, Object>> preciseWorkOrders;
    private List<String> hiddenFloorCodes;
    private List<Map<String, Object>> mergedData;
}