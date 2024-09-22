package com.zg.hrjob_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("candidates")
public class Candidate {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String school;
    private String socialSecurityTime;
    private LocalDateTime entryTime;
    private String major;
    private String interviewStatus;
    private String interviewer;
    private String interviewerComments;
}