package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.LectureDao;

public class LectureDeleteController implements Command {
  private LectureDao lectureDao;

  public LectureDeleteController() {
    lectureDao = LectureDao.getInstance();
  }

  //클라이언트에서 보낸 데이터 형식
  // => lecture/delete?lectureName=자바
  public void service(HashMap<String,String> paramMap, PrintStream out) {
      
    if (!lectureDao.existLectureName(paramMap.get("lectureName"))) {
      out.println("해당 데이터가 없습니다.");
      return;
    }
      
    lectureDao.delete(paramMap.get("lectureName"));
    out.println("해당 데이터를 삭제 완료하였습니다.");
  }
}




