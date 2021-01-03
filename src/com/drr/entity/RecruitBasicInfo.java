package com.drr.entity;

public class RecruitBasicInfo {
    private Integer recruitBasicInfoID;     //          招聘信息id
    private Integer companyId;           //          发布招聘信息的用户的id
    private String jobName;               //          工作名称
    private String jobType;                //        工作类型
    private Integer recruitForNumber;    //         招聘人数
    private Integer salary;             //         月薪
    private String degree;         //             学历要求
    private String workAddress;         //       工作地址
    private String jobDecription;      //       工作描述

    public RecruitBasicInfo(Integer recruitBasicInfoID, Integer companyId, String jobName, String jobType, Integer recruitForNumber, Integer salary, String degree, String workAddress, String jobDecription) {
        this.recruitBasicInfoID = recruitBasicInfoID;
        this.companyId = companyId;
        this.jobName = jobName;
        this.jobType = jobType;
        this.recruitForNumber = recruitForNumber;
        this.salary = salary;
        this.degree = degree;
        this.workAddress = workAddress;
        this.jobDecription = jobDecription;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Integer getRecruitBasicInfoID() {
        return recruitBasicInfoID;
    }

    public void setRecruitBasicInfoID(Integer recruitBasicInfoID) {
        this.recruitBasicInfoID = recruitBasicInfoID;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Integer getRecruitForNumber() {
        return recruitForNumber;
    }

    public void setRecruitForNumber(Integer recruitForNumber) {
        this.recruitForNumber = recruitForNumber;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getJobDecription() {
        return jobDecription;
    }

    public void setJobDecription(String jobDecription) {
        this.jobDecription = jobDecription;
    }

    @Override
    public String toString() {
        return "RecruitBasicInfo{" +
                "recruitBasicInfoID=" + recruitBasicInfoID +
                ", applicantId=" + companyId +
                ", jobName='" + jobName + '\'' +
                ", jobType='" + jobType + '\'' +
                ", recruitForNumber=" + recruitForNumber +
                ", salary=" + salary +
                ", degree='" + degree + '\'' +
                ", workAddress='" + workAddress + '\'' +
                ", jobDecription='" + jobDecription + '\'' +
                '}';
    }
}
