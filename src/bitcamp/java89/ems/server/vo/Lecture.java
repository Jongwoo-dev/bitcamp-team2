package bitcamp.java89.ems.server.vo;

import java.io.Serializable;

public class Lecture implements Serializable {
	private static final long serialVersionUID = 1L;
//인스턴스 변수
  String lectureName; // 강좌명
  String introduce; // 강좌소개
  String benefit; // 강좌특전
  String target;  // 강좌대상
  String document; // 강좌서류
  boolean levelTest; //레벨테스트여부
  int time; 		// 강좌시간
  String place; 	//강좌장소

  public Lecture() {}

public Lecture(String lectureName, String introduce, String benefit, String target, String document, boolean levelTest,
		int time, String place) {
	this.lectureName = lectureName;
	this.introduce = introduce;
	this.benefit = benefit;
	this.target = target;
	this.document = document;
	this.levelTest = levelTest;
	this.time = time;
	this.place = place;
}

public String getLectureName() {
	return lectureName;
}

public void setLectureName(String lectureName) {
	this.lectureName = lectureName;
}

public String getIntroduce() {
	return introduce;
}

public void setIntroduce(String introduce) {
	this.introduce = introduce;
}

public String getBenefit() {
	return benefit;
}

public void setBenefit(String benefit) {
	this.benefit = benefit;
}

public String getTarget() {
	return target;
}

public void setTarget(String target) {
	this.target = target;
}

public String getDocument() {
	return document;
}

public void setDocument(String document) {
	this.document = document;
}

public boolean isLevelTest() {
	return levelTest;
}

public void setLevelTest(boolean levelTest) {
	this.levelTest = levelTest;
}

public int getTime() {
	return time;
}

public void setTime(int time) {
	this.time = time;
}

public String getPlace() {
	return place;
}

public void setPlace(String place) {
	this.place = place;
}
    
  }

