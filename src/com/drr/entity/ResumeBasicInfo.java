package com.drr.entity;

public class ResumeBasicInfo {
    private int basicInfoId;          //    简历基本信息编号
    private int applicantId;         //     申请人Applicant对应编号
    private String applicantName;     //    用户姓名
    private String applicantSex;     //     用户性别
    private String applicantBirthday;  //    用户生日日期
    private String applicantTelephone; //    用户电话号码
    private String applicantSchool;     //    用户毕业学校
    private String applicantProfession;  //    所学专业
    private String applicantJobUntenion;  //   工作意向
    private String applicantWorkExe;     //    工作经验
    private String applicantEmail;     //      用户邮箱
    private String applicantDegree;    //      用户学历

    public String getApplicantDegree() {
        return applicantDegree;
    }

    public void setApplicantDegree(String applicantDegree) {
        this.applicantDegree = applicantDegree;
    }

    public ResumeBasicInfo(int basicInfoId, int applicantId, String applicantName, String applicantSex, String applicantBirthday, String applicantTelephone, String applicantSchool,String applicantDegree ,String applicantProfession, String applicantJobUntenion, String applicantWorkExe, String applicantEmail) {
        this.basicInfoId = basicInfoId;
        this.applicantId = applicantId;
        this.applicantName = applicantName;
        this.applicantSex = applicantSex;
        this.applicantBirthday = applicantBirthday;
        this.applicantTelephone = applicantTelephone;
        this.applicantSchool = applicantSchool;
        this.applicantProfession = applicantProfession;
        this.applicantJobUntenion = applicantJobUntenion;
        this.applicantWorkExe = applicantWorkExe;
        this.applicantEmail = applicantEmail;
        this.applicantDegree = applicantDegree;
    }

    public int getBasicInfoId() {
        return basicInfoId;
    }

    public void setBasicInfoId(int basicInfoId) {
        this.basicInfoId = basicInfoId;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantSex() {
        return applicantSex;
    }

    public void setApplicantSex(String applicantSex) {
        this.applicantSex = applicantSex;
    }

    public String getApplicantBirthday() {
        return applicantBirthday;
    }

    public void setApplicantBirthday(String applicantBirthday) {
        this.applicantBirthday = applicantBirthday;
    }

    public String getApplicantTelephone() {
        return applicantTelephone;
    }

    public void setApplicantTelephone(String applicantTelephone) {
        this.applicantTelephone = applicantTelephone;
    }

    public String getApplicantSchool() {
        return applicantSchool;
    }

    public void setApplicantSchool(String applicantSchool) {
        this.applicantSchool = applicantSchool;
    }

    public String getApplicantProfession() {
        return applicantProfession;
    }

    public void setApplicantProfession(String applicantProfession) {
        this.applicantProfession = applicantProfession;
    }

    public String getApplicantJobUntenion() {
        return applicantJobUntenion;
    }

    public void setApplicantJobUntenion(String applicantJobUntenion) {
        this.applicantJobUntenion = applicantJobUntenion;
    }

    public String getApplicantWorkExe() {
        return applicantWorkExe;
    }

    public void setApplicantWorkExe(String applicantWorkExe) {
        this.applicantWorkExe = applicantWorkExe;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    @Override
    public String toString() {
        return "ResumeBasicInfo{" +
                "basicInfoId=" + basicInfoId +
                ", applicantId=" + applicantId +
                ", applicantName='" + applicantName + '\'' +
                ", applicantSex='" + applicantSex + '\'' +
                ", applicantBirthday='" + applicantBirthday + '\'' +
                ", applicantTelephone='" + applicantTelephone + '\'' +
                ", applicantSchool='" + applicantSchool + '\'' +
                ", applicantProfession='" + applicantProfession + '\'' +
                ", applicantJobUntenion='" + applicantJobUntenion + '\'' +
                ", applicantWorkExe='" + applicantWorkExe + '\'' +
                ", applicantEmail='" + applicantEmail + '\'' +
                '}';
    }
}
