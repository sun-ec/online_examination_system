package com.oes.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


public class SmdQuestions  implements Serializable {

  private String id;
  private String question;
  private String correct;
  private String questionType;
  private String techCateId;
  private String descrpt;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date pubdate;
  private TechCategory techCategory;

  public SmdQuestions() {
  }

  public SmdQuestions(String id, String question, String correct, String questionType, String techCateId, String descrpt, Date pubdate, TechCategory techCategory) {
    this.id = id;
    this.question = question;
    this.correct = correct;
    this.questionType = questionType;
    this.techCateId = techCateId;
    this.descrpt = descrpt;
    this.pubdate = pubdate;
    this.techCategory = techCategory;
  }

  @Override
  public String toString() {
    return "SmdQuestions{" +
            "id='" + id + '\'' +
            ", question='" + question + '\'' +
            ", correct='" + correct + '\'' +
            ", questionType='" + questionType + '\'' +
            ", techCateId='" + techCateId + '\'' +
            ", descrpt='" + descrpt + '\'' +
            ", pubdate=" + pubdate +
            ", techCategory=" + techCategory +
            '}';
  }

  public TechCategory getTechCategory() {
    return techCategory;
  }

  public void setTechCategory(TechCategory techCategory) {
    this.techCategory = techCategory;
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


  public String getCorrect() {
    return correct;
  }

  public void setCorrect(String correct) {
    this.correct = correct;
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
  public String getDescrpt() {
    return descrpt;
  }

  public void setDescrpt(String descrpt) {
    this.descrpt = descrpt;
  }


  public Date getPubdate() {
    return pubdate;
  }

  public void setPubdate(Date pubdate) {
    this.pubdate = pubdate;
  }

}
