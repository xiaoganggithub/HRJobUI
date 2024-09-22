package com.zg.hrjob_server.controller;

import com.zg.hrjob_server.common.ApiResponse;
import com.zg.hrjob_server.entity.Candidate;
import com.zg.hrjob_server.exception.ResourceNotFoundException;
import com.zg.hrjob_server.service.impl.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 候选人控制器
 * 处理与候选人相关的HTTP请求
 */
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateServiceImpl candidateService;

    /**
     * 获取所有候选人信息
     * 
     * 该方法处理GET请求，返回系统中所有候选人的列表
     * 
     * @return ApiResponse<List<Candidate>> 包含所有候选人信息的列表
     */
    @GetMapping
    public ApiResponse<List<Candidate>> getAllCandidates() {
        List<Candidate> candidates = candidateService.list();
        return ApiResponse.success(candidates);
    }

    /**
     * 根据ID获取候选人信息
     * 
     * 该方法处理GET请求，根据提供的ID获取指定候选人的信息
     * 
     * @param id 要获取的候选人ID
     * @return ApiResponse<Candidate> 包含候选人信息的响应
     */
    @GetMapping("/{id}")
    public ApiResponse<Candidate> getCandidateById(@PathVariable Long id) {
        Candidate candidate = candidateService.getById(id);
        if (candidate == null) {
            throw new ResourceNotFoundException("Candidate not found with id: " + id);
        }
        return ApiResponse.success(candidate);
    }

    /**
     * 添加新的候选人
     * 
     * 该方法处理POST请求，接收候选人信息并将其保存到系统中
     * 
     * @param candidate 要添加的候选人信息，包含姓名、学校、专业等详细信息
     * @return ApiResponse<Candidate> 添加操作是否成功
     */
    @PostMapping
    public ApiResponse<Candidate> createCandidate(@RequestBody Candidate candidate) {
        boolean success = candidateService.save(candidate);
        if (!success) {
            throw new RuntimeException("Failed to create candidate");
        }
        return ApiResponse.success(candidate);
    }

    /**
     * 更新候选人信息
     * 
     * 该方法处理PUT请求，根据提供的ID更新指定候选人的信息
     * 
     * @param id 要更新的候选人ID
     * @param candidate 更新后的候选人信息，包含需要更新的字段
     * @return ApiResponse<Candidate> 更新操作是否成功
     */
    @PutMapping("/{id}")
    public ApiResponse<Candidate> updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        candidate.setId(id);
        boolean success = candidateService.updateById(candidate);
        if (!success) {
            throw new ResourceNotFoundException("Candidate not found with id: " + id);
        }
        return ApiResponse.success(candidate);
    }

    /**
     * 删除候选人
     * 
     * 该方法处理DELETE请求，根据提供的ID删除指定的候选人
     * 
     * @param id 要删除的候选人ID
     * @return ApiResponse<Void> 删除操作是否成功
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteCandidate(@PathVariable Long id) {
        boolean success = candidateService.removeById(id);
        if (!success) {
            throw new ResourceNotFoundException("Candidate not found with id: " + id);
        }
        return ApiResponse.success();
    }
}