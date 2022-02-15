package com.oes.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

public class FspQuestions  implements Serializable {

  private String id;
  private String question;
  private String stdAnswer;
  private String questionType;
  private String techCateId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date pubdate;
  private String descrpt;
  private TechCategory techCategory;

  public FspQuestions() {
  }

  public FspQuestions(String id, String question, String stdAnswer, String questionType, String techCateId, Date pubdate, String descrpt, TechCategory techCategory) {
    this.id = id;
    this.question = question;
    this.stdAnswer = stdAnswer;
    this.questionType = questionType;
    this.techCateId = techCateId;
    this.pubdate = pubdate;
    this.descrpt = descrpt;
    this.techCategory = techCategory;
  }

  @Override
  public String toString() {
    return "FspQuestions{" +
            "id='" + id + '\'' +
            ", question='" + question + '\'' +
            ", stdAnswer='" + stdAnswer + '\'' +
            ", questionType='" + questionType + '\'' +
            ", techCateId='" + techCateId + '\'' +
            ", pubdate=" + pubdate +
            ", descrpt='" + descrpt + '\'' +
            ", techCategory=" + techCategory +
            '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getStdAnswer() {
    return stdAnswer;
  }

  public void setStdAnswer(String stdAnswer) {
    this.stdAnswer = stdAnswer;
  }

  public String getQuestionType() {
    return questionType;
  }

  public void setQuestionType(String questionType) {
    this.questionType = questionType;
  }

  public String getTechCateId() {
    return techCateId;
  }

  public void setTechCateId(String techCateId) {
    this.techCateId = techCateId;
  }

  public Date getPubdate() {
    return pubdate;
  }

  public void setPubdate(Date pubdate) {
    this.pubdate = pubdate;
  }

  public String getDescrpt() {
    return descrpt;
  }

  public void setDescrpt(String descrpt) {
    this.descrpt = descrpt;
  }

  public TechCategory getTechCategory() {
    return techCategory;
  }

  public void setTechCategory(TechCategory techCategory) {
    this.techCategory = techCategory;
  }
}
