package bitcamp.java89.ems.server.vo;

import java.io.Serializable;

public class TextBook implements Serializable {
  //인스턴스 변수
  String title;
  String author;
  String press;
  String releaseDate;
  String language;
  String description;


  public TextBook(){
   
  }

  public TextBook(String title, String author){
    this.title = title;
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPress() {
    return press;
  }

  public void setPress(String press) {
    this.press = press;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "TextBook [title=" + title + ", author=" + author + "]";
  }

}
