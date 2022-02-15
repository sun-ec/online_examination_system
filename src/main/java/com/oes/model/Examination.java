package com.oes.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

public class Examination implements Serializable {

  private String examNo;
  private String userId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date examDate;
  private String singleId;
  private String multipleId;
  private String trueFalseId;
  private String simpleAnwserId;
  private String programId;
  private String descrpt;
  private String validFlag;
  private OltsUsers oltsUsers;

  public Examination() {
  }

  public Examination(String examNo, String userId, Date examDate, String singleId, String multipleId, String trueFalseId, String simpleAnwserId, String programId, String descrpt, String validFlag, OltsUsers oltsUsers) {
    this.examNo = examNo;
    this.userId = userId;
    this.examDate = examDate;
    this.singleId = singleId;
    this.multipleId = multipleId;
    this.trueFalseId = trueFalseId;
    this.simpleAnwserId = simpleAnwserId;
    this.programId = programId;
    this.descrpt = descrpt;
    this.validFlag = validFlag;
    this.oltsUsers = oltsUsers;
  }

  @Override
  public String toString() {
    return "Examination{" +
            "examNo='" + examNo + '\'' +
            ", userId='" + userId + '\'' +
            ", examDate=" + examDate +
            ", singleId='" + singleId + '\'' +
            ", multipleId='" + multipleId + '\'' +
            ", trueFalseId='" + trueFalseId + '\'' +
            ", simpleAnwserId='" + simpleAnwserId + '\'' +
            ", programId='" + programId + '\'' +
            ", descrpt='" + descrpt + '\'' +
            ", validFlag='" + validFlag + '\'' +
            ", oltsUsers=" + oltsUsers +
            '}';
  }

  public OltsUsers getOltsUsers() {
    return oltsUsers;
  }

  public void setOltsUsers(OltsUsers oltsUsers) {
    this.oltsUsers = oltsUsers;
  }

  public String getExamNo() {
    return examNo;
  }

  public void setExamNo(String examNo) {
    this.examNo = examNo;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public Date getExamDate() {
    return examDate;
  }

  public void setExamDate(java.sql.Date examDate) {
    this.examDate = examDate;
  }


  public String getSingleId() {
    return singleId;
  }

  public void setSingleId(String singleId) {
    this.singleId = singleId;
  }


  public String getMultipleId() {
    return multipleId;
  }

  public void setMultipleId(String multipleId) {
    this.multipleId = multipleId;
  }


  public String getTrueFalseId() {
    return trueFalseId;
  }

  public void setTrueFalseId(String trueFalseId) {
    this.trueFalseId = trueFalseId;
  }

  public String getSimpleAnwserId() {
    return simpleAnwserId;
  }

  public void setSimpleAnwserId(String simpleAnwserId) {
    this.simpleAnwserId = simpleAnwserId;
  }


  public String getProgramId() {
    return programId;
  }

  public void setProgramId(String programId) {
    this.programId = programId;
  }


  public String getDescrpt() {
    return descrpt;
  }

  public void setDescrpt(String descrpt) {
    this.descrpt = descrpt;
  }


  public String getValidFlag() {
    return validFlag;
  }

  public void setValidFlag(String validFlag) {
    this.validFlag = validFlag;
  }

}
