package com.zg.hrjob_server.controller;

import com.zg.hrjob_server.chain.DataContext;
import com.zg.hrjob_server.chain.DataProcessor;
import com.zg.hrjob_server.chain.DataProcessorChainBuilder;
import com.zg.hrjob_server.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class DataController {
    private final DataProcessorChainBuilder chainBuilder;
    private final RestTemplate restTemplate;

    @Autowired
    public DataController(DataProcessorChainBuilder chainBuilder, RestTemplate restTemplate) {
        this.chainBuilder = chainBuilder;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/process")
    public ApiResponse<List<Map<String, Object>>> processData(@RequestParam List<String> hiddenFloorCodes) {
        DataProcessor chain = chainBuilder.buildChain();
        DataContext context = new DataContext();
        context.setHiddenFloorCodes(hiddenFloorCodes);

        chain.process(context);

        return ApiResponse.success(context.getMergedData());
    }
}