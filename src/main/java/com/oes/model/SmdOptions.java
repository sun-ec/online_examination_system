package com.oes.model;


import java.io.Serializable;

public class SmdOptions  implements Serializable {

  private String id;
  private String optionA;
  private String optionB;
  private String optionC;
  private String optionD;
  private String optionE;
  private String questionId;
  private SmdQuestions smdQuestions;

  public SmdOptions() {
  }

  public SmdOptions(String id, String optionA, String optionB, String optionC, String optionD, String optionE, String questionId, SmdQuestions smdQuestions) {
    this.id = id;
    this.optionA = optionA;
    this.optionB = optionB;
    this.optionC = optionC;
    this.optionD = optionD;
    this.optionE = optionE;
    this.questionId = questionId;
    this.smdQuestions = smdQuestions;
  }

  @Override
  public String toString() {
    return "SmdOptions{" +
            "id='" + id + '\'' +
            ", optionA='" + optionA + '\'' +
            ", optionB='" + optionB + '\'' +
            ", optionC='" + optionC + '\'' +
            ", optionD='" + optionD + '\'' +
            ", optionE='" + optionE + '\'' +
            ", questionId='" + questionId + '\'' +
            ", smdQuestions=" + smdQuestions +
            '}';
  }

  public SmdQuestions getSmdQuestions() {
    return smdQuestions;
  }

  public void setSmdQuestions(SmdQuestions smdQuestions) {
    this.smdQuestions = smdQuestions;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getOptionA() {
    return optionA;
  }

  public void setOptionA(String optionA) {
    this.optionA = optionA;
  }


  public String getOptionB() {
    return optionB;
  }

  public void setOptionB(String optionB) {
    this.optionB = optionB;
  }


  public String getOptionC() {
    return optionC;
  }

  public void setOptionC(String optionC) {
    this.optionC = optionC;
  }


  public String getOptionD() {
    return optionD;
  }

  public void setOptionD(String optionD) {
    this.optionD = optionD;
  }


  public String getOptionE() {
    return optionE;
  }

  public void setOptionE(String optionE) {
    this.optionE = optionE;
  }


  public String getQuestionId() {
    return questionId;
  }

  public void setQuestionId(String questionId) {
    this.questionId = questionId;
  }

}
