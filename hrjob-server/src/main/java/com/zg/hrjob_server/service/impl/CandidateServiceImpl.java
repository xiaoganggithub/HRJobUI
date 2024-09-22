package com.zg.hrjob_server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zg.hrjob_server.entity.Candidate;
import com.zg.hrjob_server.mapper.CandidateMapper;
import com.zg.hrjob_server.service.ICandidateService;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl extends ServiceImpl<CandidateMapper, Candidate> implements ICandidateService {
}