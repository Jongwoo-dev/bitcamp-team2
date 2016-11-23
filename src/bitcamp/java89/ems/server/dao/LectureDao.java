package bitcamp.java89.ems.server.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitcamp.java89.ems.server.vo.Contact;
import bitcamp.java89.ems.server.vo.Lecture;

public class LectureDao {
  static LectureDao obj;
  
  private String filename = "lecture-v1.7.data";
  private ArrayList<Lecture> list;

  public static LectureDao getInstance() {
    if (obj == null) {
      obj = new LectureDao();
    }
    
    return obj;
  }
  
  public LectureDao() {
    this.load(); 
  }

  public ArrayList<Lecture> getList() {
    return this.list;
  }
  
  
  synchronized public void insert(Lecture lecture) {
    list.add(lecture);
    try {this.save();} catch (Exception e) {}
  }
  
  synchronized public void update(Lecture lecture) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getLectureName().equals(lecture.getLectureName())) {
        list.set(i, lecture);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }
  
  synchronized public void delete(String lectureName) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getLectureName().equals(lectureName)) {
        list.remove(i);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }
  
  synchronized public Lecture getOne(String lectureName) {
	    for (Lecture lecture : list) {
	      if (lecture.getLectureName().equals(lectureName)) {
	        return lecture;
	      }
	    }
	    return null;
	  }
  
  public boolean existLectureName(String lectureName) {
    for (Lecture lecture : list) {
      if (lecture.getLectureName().equals(lectureName)) {
        return true;
      }
    }
    return false;
  }
  
  
  @SuppressWarnings("unchecked")
  private void load() {
    FileInputStream in0 = null;
    ObjectInputStream in = null;
    
    try {
      in0 = new FileInputStream(this.filename);
      in = new ObjectInputStream(in0);

      list = (ArrayList<Lecture>)in.readObject();
      
    } catch (EOFException e) {
      // 파일을 모두 읽었다.
    } catch (Exception e) {
      System.out.println("학생 데이터 로딩 중 오류 발생!");
      list = new ArrayList<>();
    } finally {
      try {
        in.close();
        in0.close();
      } catch (Exception e) {
        // close하다가 예외 발생하면 무시한다.
      }
    }
  }
  
  public ArrayList<Lecture> getListByName(String lectureName) {
	    ArrayList<Lecture> results = new ArrayList<>();
	    for (Lecture lecture : list) {
	      if (lecture.getLectureName().equals(lectureName)) {
	        results.add(lecture);
	      }
	    }
	    return results;
	  }

  synchronized public void save() throws Exception {
    FileOutputStream out0 = new FileOutputStream(this.filename);
    ObjectOutputStream out = new ObjectOutputStream(out0);

    out.writeObject(list);

    out.close();
    out0.close();
  }

}
