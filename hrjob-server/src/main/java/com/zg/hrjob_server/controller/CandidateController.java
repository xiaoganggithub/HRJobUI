package com.zg.hrjob_server.controller;

import com.zg.hrjob_server.entity.Candidate;
import com.zg.hrjob_server.service.ICandidateService;
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
    private ICandidateService candidateService;

    /**
     * 获取所有候选人信息
     * 
     * 该方法处理GET请求，返回系统中所有候选人的列表
     * 
     * @return List<Candidate> 包含所有候选人信息的列表
     */
    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateService.list();
    }

    /**
     * 添加新的候选人
     * 
     * 该方法处理POST请求，接收候选人信息并将其保存到系统中
     * 
     * @param candidate 要添加的候选人信息，包含姓名、学校、专业等详细信息
     * @return boolean 添加操作是否成功
     */
    @PostMapping
    public boolean addCandidate(@RequestBody Candidate candidate) {
        return candidateService.save(candidate);
    }

    /**
     * 更新候选人信息
     * 
     * 该方法处理PUT请求，根据提供的ID更新指定候选人的信息
     * 
     * @param id 要更新的候选人ID
     * @param candidate 更新后的候选人信息，包含需要更新的字段
     * @return boolean 更新操作是否成功
     */
    @PutMapping("/{id}")
    public boolean updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        candidate.setId(id);
        return candidateService.updateById(candidate);
    }

    /**
     * 删除候选人
     * 
     * 该方法处理DELETE请求，根据提供的ID删除指定的候选人
     * 
     * @param id 要删除的候选人ID
     * @return boolean 删除操作是否成功
     */
    @DeleteMapping("/{id}")
    public boolean deleteCandidate(@PathVariable Long id) {
        return candidateService.removeById(id);
    }
}