package com.example.hrjob.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hrjob.entity.Candidate;
import com.example.hrjob.mapper.CandidateMapper;
import com.example.hrjob.service.CandidateService;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl extends ServiceImpl<CandidateMapper, Candidate> implements CandidateService {
}