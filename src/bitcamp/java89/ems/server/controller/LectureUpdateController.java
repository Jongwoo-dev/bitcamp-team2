package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.LectureDao;
import bitcamp.java89.ems.server.vo.Contact;
import bitcamp.java89.ems.server.vo.Lecture;

public class LectureUpdateController implements Command {
	private LectureDao lectureDao;

	public LectureUpdateController() {
		lectureDao = LectureDao.getInstance();
	}

	// 클라이언트에서 보낸 데이터 형식
	// => lecture/update?lectureName=자바&introduce=DB&benefit=강좌&target=학생&document=증명사진&levelTest=y&time=10&place=서초구
	public void service(HashMap<String, String> paramMap, PrintStream out) {
		if (!lectureDao.existLectureName(paramMap.get("lectureName"))) {
		      out.println("해당 아이디의 학생이 없습니다.");
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
		    
		    lectureDao.update(lecture);
		    out.println("학생 정보를 변경하였습니다.");
		  }
	}

