package com.example.hrjob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hrjob.entity.Candidate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CandidateMapper extends BaseMapper<Candidate> {
}