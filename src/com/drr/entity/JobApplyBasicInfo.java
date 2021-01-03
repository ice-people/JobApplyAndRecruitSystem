package com.drr.entity;

public class JobApplyBasicInfo {
    private Integer jobApplyBasicInfoId;
    private Integer applicantId;
    private String jobApplyType;
    private String jobApplySalary;
    private String jobApplyForAddress;

    public JobApplyBasicInfo(Integer jobApplyBasicInfoId, Integer applicantId, String jobApplyType, String jobApplySalary, String jobApplyForAddress) {
        this.jobApplyBasicInfoId = jobApplyBasicInfoId;
        this.applicantId = applicantId;
        this.jobApplyType = jobApplyType;
        this.jobApplySalary = jobApplySalary;
        this.jobApplyForAddress = jobApplyForAddress;
    }

    public Integer getJobApplyBasicInfoId() {
        return jobApplyBasicInfoId;
    }

    public void setJobApplyBasicInfoId(Integer jobApplyBasicInfoId) {
        this.jobApplyBasicInfoId = jobApplyBasicInfoId;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getJobApplyType() {
        return jobApplyType;
    }

    public void setJobApplyType(String jobApplyType) {
        this.jobApplyType = jobApplyType;
    }

    public String getJobApplySalary() {
        return jobApplySalary;
    }

    public void setJobApplySalary(String jobApplySalary) {
        this.jobApplySalary = jobApplySalary;
    }

    public String getJobApplyForAddress() {
        return jobApplyForAddress;
    }

    public void setJobApplyForAddress(String jobApplyForAddress) {
        this.jobApplyForAddress = jobApplyForAddress;
    }

    @Override
    public String toString() {
        return "jobApplyBasicInfoDao{" +
                "jobApplyBasicInfoId=" + jobApplyBasicInfoId +
                ", applicantId=" + applicantId +
                ", jobApplyType='" + jobApplyType + '\'' +
                ", jobApplySalary='" + jobApplySalary + '\'' +
                ", jobApplyForAddress='" + jobApplyForAddress + '\'' +
                '}';
    }
}
