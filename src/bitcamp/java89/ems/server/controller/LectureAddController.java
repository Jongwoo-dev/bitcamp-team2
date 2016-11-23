package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.LectureDao;
import bitcamp.java89.ems.server.vo.Contact;
import bitcamp.java89.ems.server.vo.Lecture;

public class LectureAddController implements Command {
  private LectureDao lectureDao;

  public LectureAddController() {
    lectureDao = LectureDao.getInstance();
  }

  //클라이언트에서 보낸 데이터 형식
  // => lecture/add?lectureName=자바&introduce=DB&benefit=강좌&target=학생&document=증명사진&levelTest=y&time=10&place=강남
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (lectureDao.existLectureName(paramMap.get("lectureName"))) {
      out.println("같은 강좌서류가 존재합니다. 등록을 취소합니다.");
      return;
    }
      
      Lecture lecture = new Lecture();
      lecture.setLectureName(paramMap.get("lectureName"));
      lecture.setIntroduce(paramMap.get("introduce"));
      lecture.setBenefit(paramMap.get("benefit"));
      lecture.setTarget(paramMap.get("target"));
      lecture.setDocument(paramMap.get("document"));
      lecture.setLevelTest(paramMap.get("levelTest").equals("y") ? true : false);
      lecture.setTime(Integer.parseInt(paramMap.get("time")));
      lecture.setPlace(paramMap.get("place"));

      lectureDao.insert(lecture);
      out.println("등록하였습니다.");
    
  }
}




