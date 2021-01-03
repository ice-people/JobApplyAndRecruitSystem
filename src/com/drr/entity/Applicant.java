package com.drr.entity;

import java.sql.Date;

public class Applicant {
    private Integer applicantID;
    private String userName;
    private String applicantEmail;
    private String applicantPwd;
    private Date applicantRegisterData;

    public Applicant(Integer applicantID, String userName, String applicantEmail, String applicantPwd, Date applicantRegisterData) {
        this.applicantID = applicantID;
        this.userName = userName;
        this.applicantEmail = applicantEmail;
        this.applicantPwd = applicantPwd;
        this.applicantRegisterData = applicantRegisterData;
    }

    public Integer getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Integer applicantID) {
        this.applicantID = applicantID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantPwd() {
        return applicantPwd;
    }

    public void setApplicantPwd(String applicantPwd) {
        this.applicantPwd = applicantPwd;
    }

    public Date getApplicantRegisterData() {
        return applicantRegisterData;
    }

    public void setApplicantRegisterData(Date applicantRegisterData) {
        this.applicantRegisterData = applicantRegisterData;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicantID=" + applicantID +
                ", userName='" + userName + '\'' +
                ", applicantEmail='" + applicantEmail + '\'' +
                ", applicantPwd='" + applicantPwd + '\'' +
                ", applicantRegisterData=" + applicantRegisterData +
                '}';
    }
}

