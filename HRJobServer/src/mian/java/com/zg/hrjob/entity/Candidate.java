package com.example.hrjob.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

@Data
@TableName("candidate")
public class Candidate {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String school;
    private String socialSecurityTime;
    private LocalDate entryDate;
    private String major;
    private String interviewStatus;
    private String interviewer;
    private String interviewerComments;
}