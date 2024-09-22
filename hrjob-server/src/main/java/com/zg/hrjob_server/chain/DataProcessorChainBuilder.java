package com.zg.hrjob_server.chain;

import org.springframework.stereotype.Component;

@Component
public class DataProcessorChainBuilder {
    private final FloorLayoutProcessor floorLayoutProcessor;
    private final WorkOrderProcessor workOrderProcessor;
    private final PreciseWorkOrderProcessor preciseWorkOrderProcessor;
    private final DataFilterProcessor dataFilterProcessor;
    private final WorkOrderPriorityProcessor workOrderPriorityProcessor;
    private final DataMergeProcessor dataMergeProcessor;

    public DataProcessorChainBuilder(FloorLayoutProcessor floorLayoutProcessor,
                                     WorkOrderProcessor workOrderProcessor,
                                     PreciseWorkOrderProcessor preciseWorkOrderProcessor,
                                     DataFilterProcessor dataFilterProcessor,
                                     WorkOrderPriorityProcessor workOrderPriorityProcessor,
                                     DataMergeProcessor dataMergeProcessor) {
        this.floorLayoutProcessor = floorLayoutProcessor;
        this.workOrderProcessor = workOrderProcessor;
        this.preciseWorkOrderProcessor = preciseWorkOrderProcessor;
        this.dataFilterProcessor = dataFilterProcessor;
        this.workOrderPriorityProcessor = workOrderPriorityProcessor;
        this.dataMergeProcessor = dataMergeProcessor;
    }

    public DataProcessor buildChain() {
        floorLayoutProcessor.setNextProcessor(workOrderProcessor);
        workOrderProcessor.setNextProcessor(preciseWorkOrderProcessor);
        preciseWorkOrderProcessor.setNextProcessor(dataFilterProcessor);
        dataFilterProcessor.setNextProcessor(workOrderPriorityProcessor);
        workOrderPriorityProcessor.setNextProcessor(dataMergeProcessor);

        return floorLayoutProcessor;
    }
}