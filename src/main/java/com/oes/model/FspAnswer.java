package com.oes.model;

import java.io.Serializable;

public class FspAnswer implements Serializable {

  private String id;
  private String answer;
  private String fspId;
  private String examNo;
  private String userId;
  private FspQuestions fspQuestions;
  private Examination examination;
  private OltsUsers oltsUsers;

  public FspAnswer() {
  }

  public FspAnswer(String id, String answer, String fspId, String examNo, String userId, FspQuestions fspQuestions, Examination examination, OltsUsers oltsUsers) {
    this.id = id;
    this.answer = answer;
    this.fspId = fspId;
    this.examNo = examNo;
    this.userId = userId;
    this.fspQuestions = fspQuestions;
    this.examination = examination;
    this.oltsUsers = oltsUsers;
  }

  @Override
  public String toString() {
    return "FspAnswer{" +
            "id='" + id + '\'' +
            ", answer='" + answer + '\'' +
            ", fspId='" + fspId + '\'' +
            ", examNo='" + examNo + '\'' +
            ", userId='" + userId + '\'' +
            ", fspQuestions=" + fspQuestions +
            ", examination=" + examination +
            ", oltsUsers=" + oltsUsers +
            '}';
  }

  public FspQuestions getFspQuestions() {
    return fspQuestions;
  }

  public void setFspQuestions(FspQuestions fspQuestions) {
    this.fspQuestions = fspQuestions;
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


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public String getFspId() {
    return fspId;
  }

  public void setFspId(String fspId) {
    this.fspId = fspId;
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

}
