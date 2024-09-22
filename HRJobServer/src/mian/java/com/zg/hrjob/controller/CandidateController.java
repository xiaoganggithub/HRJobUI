package com.example.hrjob.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hrjob.entity.Candidate;
import com.example.hrjob.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public Page<Candidate> listCandidates(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String school,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        QueryWrapper<Candidate> queryWrapper = new QueryWrapper<>();
        if (name != null && !name.isEmpty()) {
            queryWrapper.like("name", name);
        }
        if (school != null && !school.isEmpty()) {
            queryWrapper.like("school", school);
        }
        if (startDate != null && endDate != null) {
            queryWrapper.between("entry_date", startDate, endDate);
        }

        return candidateService.page(new Page<>(page, size), queryWrapper);
    }

    @PostMapping
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        candidateService.save(candidate);
        return candidate;
    }

    @PutMapping("/{id}")
    public Candidate updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        candidate.setId(id);
        candidateService.updateById(candidate);
        return candidate;
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidateService.removeById(id);
    }

    @GetMapping("/{id}")
    public Candidate getCandidate(@PathVariable Long id) {
        return candidateService.getById(id);
    }
}