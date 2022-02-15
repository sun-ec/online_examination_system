package com.oes.model;


import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

public class OltsUsers  implements Serializable {

  private String id;
  private String stuNo;
  private String idCardNo;
  private String userName;
  private String passWord;
  private String mobile;
  private String homeTel;
  private String homeAddr;
  private String schAddr;
  private String qq;
  private String email;
  private String userType;
  private String gender;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthday;
  private String nationPlace;
  private String marjor;
  private String eduBackground;
  private String graduateSchool;

  public OltsUsers() {
  }

  public OltsUsers(String id, String stuNo, String idCardNo, String userName, String passWord, String mobile, String homeTel, String homeAddr, String schAddr, String qq, String email, String userType, String gender, Date birthday, String nationPlace, String marjor, String eduBackground, String graduateSchool) {
    this.id = id;
    this.stuNo = stuNo;
    this.idCardNo = idCardNo;
    this.userName = userName;
    this.passWord = passWord;
    this.mobile = mobile;
    this.homeTel = homeTel;
    this.homeAddr = homeAddr;
    this.schAddr = schAddr;
    this.qq = qq;
    this.email = email;
    this.userType = userType;
    this.gender = gender;
    this.birthday = birthday;
    this.nationPlace = nationPlace;
    this.marjor = marjor;
    this.eduBackground = eduBackground;
    this.graduateSchool = graduateSchool;
  }

  @Override
  public String toString() {
    return "OltsUsers{" +
            "id='" + id + '\'' +
            ", stuNo='" + stuNo + '\'' +
            ", idCardNo='" + idCardNo + '\'' +
            ", userName='" + userName + '\'' +
            ", passWord='" + passWord + '\'' +
            ", mobile='" + mobile + '\'' +
            ", homeTel='" + homeTel + '\'' +
            ", homeAddr='" + homeAddr + '\'' +
            ", schAddr='" + schAddr + '\'' +
            ", qq='" + qq + '\'' +
            ", email='" + email + '\'' +
            ", userType='" + userType + '\'' +
            ", gender='" + gender + '\'' +
            ", birthday=" + birthday +
            ", nationPlace='" + nationPlace + '\'' +
            ", marjor='" + marjor + '\'' +
            ", eduBackground='" + eduBackground + '\'' +
            ", graduateSchool='" + graduateSchool + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getStuNo() {
    return stuNo;
  }

  public void setStuNo(String stuNo) {
    this.stuNo = stuNo;
  }


  public String getIdCardNo() {
    return idCardNo;
  }

  public void setIdCardNo(String idCardNo) {
    this.idCardNo = idCardNo;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public String getHomeTel() {
    return homeTel;
  }

  public void setHomeTel(String homeTel) {
    this.homeTel = homeTel;
  }


  public String getHomeAddr() {
    return homeAddr;
  }

  public void setHomeAddr(String homeAddr) {
    this.homeAddr = homeAddr;
  }


  public String getSchAddr() {
    return schAddr;
  }

  public void setSchAddr(String schAddr) {
    this.schAddr = schAddr;
  }


  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }


  public String getNationPlace() {
    return nationPlace;
  }

  public void setNationPlace(String nationPlace) {
    this.nationPlace = nationPlace;
  }


  public String getMarjor() {
    return marjor;
  }

  public void setMarjor(String marjor) {
    this.marjor = marjor;
  }


  public String getEduBackground() {
    return eduBackground;
  }

  public void setEduBackground(String eduBackground) {
    this.eduBackground = eduBackground;
  }


  public String getGraduateSchool() {
    return graduateSchool;
  }

  public void setGraduateSchool(String graduateSchool) {
    this.graduateSchool = graduateSchool;
  }

}
