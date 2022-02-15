package com.oes.model;

import java.io.Serializable;

public class Courses implements Serializable{

  private String id;
  private String courseName;

  public Courses() {
  }

  public Courses(String id, String courseName) {
    this.id = id;
    this.courseName = courseName;
  }

  @Override
  public String toString() {
    return "Courses{" +
            "id='" + id + '\'' +
            ", courseName='" + courseName + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

}
