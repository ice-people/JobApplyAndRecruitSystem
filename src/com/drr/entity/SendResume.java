package com.drr.entity;

public class SendResume {
    private Integer sendResumeId;
    private Integer applicantId;
    private Integer companyId;
    private String resumeName;
    private String resumeSex;
    private String resumeSchool;
    private String resumeDegree;
    private String resumeProfession;
    private String resumeWorkExe;
    private String resumeEmail;
    private String resumeState;

    public SendResume(Integer sendResumeId, Integer applicantId, Integer companyId, String resumeName, String resumeSex, String resumeSchool, String resumeDegree, String resumeProfession, String resumeWorkExe, String resumeEmail, String resumeState) {
        this.sendResumeId = sendResumeId;
        this.applicantId = applicantId;
        this.companyId = companyId;
        this.resumeName = resumeName;
        this.resumeSex = resumeSex;
        this.resumeSchool = resumeSchool;
        this.resumeDegree = resumeDegree;
        this.resumeProfession = resumeProfession;
        this.resumeWorkExe = resumeWorkExe;
        this.resumeEmail = resumeEmail;
        this.resumeState = resumeState;
    }

    public Integer getSendResumeId() {
        return sendResumeId;
    }

    public void setSendResumeId(Integer sendResumeId) {
        this.sendResumeId = sendResumeId;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public String getResumeSex() {
        return resumeSex;
    }

    public void setResumeSex(String resumeSex) {
        this.resumeSex = resumeSex;
    }

    public String getResumeSchool() {
        return resumeSchool;
    }

    public void setResumeSchool(String resumeSchool) {
        this.resumeSchool = resumeSchool;
    }

    public String getResumeDegree() {
        return resumeDegree;
    }

    public void setResumeDegree(String resumeDegree) {
        this.resumeDegree = resumeDegree;
    }

    public String getResumeProfession() {
        return resumeProfession;
    }

    public void setResumeProfession(String resumeProfession) {
        this.resumeProfession = resumeProfession;
    }

    public String getResumeWorkExe() {
        return resumeWorkExe;
    }

    public void setResumeWorkExe(String resumeWorkExe) {
        this.resumeWorkExe = resumeWorkExe;
    }

    public String getResumeEmail() {
        return resumeEmail;
    }

    public void setResumeEmail(String resumeEmail) {
        this.resumeEmail = resumeEmail;
    }

    public String getResumeState() {
        return resumeState;
    }

    public void setResumeState(String resumeState) {
        this.resumeState = resumeState;
    }

    @Override
    public String toString() {
        return "SendResume{" +
                "sendResumeId=" + sendResumeId +
                ", applicantId=" + applicantId +
                ", companyId=" + companyId +
                ", resumeName='" + resumeName + '\'' +
                ", resumeSex='" + resumeSex + '\'' +
                ", resumeSchool='" + resumeSchool + '\'' +
                ", resumeDegree='" + resumeDegree + '\'' +
                ", resumeProfession='" + resumeProfession + '\'' +
                ", resumeWorkExe='" + resumeWorkExe + '\'' +
                ", resumeEmail='" + resumeEmail + '\'' +
                ", resumeState='" + resumeState + '\'' +
                '}';
    }
}
