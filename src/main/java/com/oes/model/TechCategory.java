package com.oes.model;

import java.io.Serializable;

public class TechCategory  implements Serializable {

  private String id;
  private String techCtgr;
  private String courseId;
  private Courses courses;

  public TechCategory() {
  }

  public TechCategory(String id, String techCtgr, String courseId, Courses courses) {
    this.id = id;
    this.techCtgr = techCtgr;
    this.courseId = courseId;
    this.courses = courses;
  }

  @Override
  public String toString() {
    return "TechCategory{" +
            "id='" + id + '\'' +
            ", techCtgr='" + techCtgr + '\'' +
            ", courseId='" + courseId + '\'' +
            ", courses=" + courses +
            '}';
  }

  public Courses getCourses() {
    return courses;
  }

  public void setCourses(Courses courses) {
    this.courses = courses;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getTechCtgr() {
    return techCtgr;
  }

  public void setTechCtgr(String techCtgr) {
    this.techCtgr = techCtgr;
  }


  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

}
