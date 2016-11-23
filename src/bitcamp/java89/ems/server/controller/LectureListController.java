package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.LectureDao;
import bitcamp.java89.ems.server.vo.Lecture;

public class LectureListController implements Command {
  private LectureDao lectureDao;

  public LectureListController() {
    lectureDao = LectureDao.getInstance();
  }
//  		lecture/list
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Lecture> list = lectureDao.getList();
    for (Lecture lecture : list) {
        out.printf("%s,%s,%s,%s,%s,%s,%d,%s\n",
          lecture.getLectureName(),
          lecture.getIntroduce(),
          lecture.getBenefit(),
          lecture.getTarget(),
          lecture.getDocument(),
          ((lecture.isLevelTest())?"yes":"no"),
          lecture.getTime(),
          lecture.getPlace());
      }
    }
  }





