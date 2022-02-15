package com.oes.model;


import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

public class OltsScore  implements Serializable {

  private String id;
  private String score;
  private String fspScore;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date testDate;
  private String descrpt;
  private String userId;
  private String examNo;
  private OltsUsers oltsUsers;
  private Examination examination;

  public OltsScore() {
  }

  public OltsScore(String id, String score, String fspScore, Date testDate, String descrpt, String userId, String examNo, OltsUsers oltsUsers, Examination examination) {
    this.id = id;
    this.score = score;
    this.fspScore = fspScore;
    this.testDate = testDate;
    this.descrpt = descrpt;
    this.userId = userId;
    this.examNo = examNo;
    this.oltsUsers = oltsUsers;
    this.examination = examination;
  }

  @Override
  public String toString() {
    return "OltsScore{" +
            "id='" + id + '\'' +
            ", score='" + score + '\'' +
            ", fspScore='" + fspScore + '\'' +
            ", testDate=" + testDate +
            ", descrpt='" + descrpt + '\'' +
            ", userId='" + userId + '\'' +
            ", examNo='" + examNo + '\'' +
            ", oltsUsers=" + oltsUsers +
            ", examination=" + examination +
            '}';
  }

  public Examination getExamination() {
    return examination;
  }

  public void setExamination(Examination examination) {
    this.examination = examination;
  }

  public OltsUsers getOltsUsers() {
    return oltsUsers;
  }

  public void setOltsUsers(OltsUsers oltsUsers) {
    this.oltsUsers = oltsUsers;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }


  public String getFspScore() {
    return fspScore;
  }

  public void setFspScore(String fspScore) {
    this.fspScore = fspScore;
  }


  public Date getTestDate() {
    return testDate;
  }

  public void setTestDate(Date testDate) {
    this.testDate = testDate;
  }


  public String getDescrpt() {
    return descrpt;
  }

  public void setDescrpt(String descrpt) {
    this.descrpt = descrpt;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getExamNo() {
    return examNo;
  }

  public void setExamNo(String examNo) {
    this.examNo = examNo;
  }

}
