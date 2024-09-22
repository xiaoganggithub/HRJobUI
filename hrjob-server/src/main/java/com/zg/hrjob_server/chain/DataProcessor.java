package com.zg.hrjob_server.chain;

public abstract class DataProcessor {
    protected DataProcessor nextProcessor;

    public void setNextProcessor(DataProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public abstract void process(DataContext context);
}