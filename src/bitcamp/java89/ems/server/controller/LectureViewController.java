package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.LectureDao;
import bitcamp.java89.ems.server.vo.Lecture;
import bitcamp.java89.ems.server.vo.Student;
import bitcamp.java89.ems.server.vo.Student;

public class LectureViewController implements Command {
  private LectureDao lectureDao;

  public LectureViewController() {
    lectureDao = LectureDao.getInstance();
  }

  //클라이언트에서 보낸 데이터 형식
  // => lecture/view?lectureName=자바
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!lectureDao.existLectureName(paramMap.get("lectureName"))) {
        out.println("해당 아이디의 학생이 없습니다.");
        return;
      }
      
      Lecture lecture = lectureDao.getOne(paramMap.get("lectureName"));
      out.printf("강좌명: %s\n", lecture.getIntroduce());
      out.printf("강좌소개: (***)\n");
      out.printf("강좌특전: %s\n", lecture.getBenefit());
      out.printf("강좌대상: %s\n", lecture.getTarget());
      out.printf("강좌서류: %s\n", lecture.getDocument());
      out.printf("레벨테스트여부: %s\n", (lecture.isLevelTest()) ? "Yes" : "No");
      out.printf("강좌시간: %d\n", lecture.getTime());
      out.printf("강좌장소: %s\n", lecture.getPlace());
      return;
    }
  }





