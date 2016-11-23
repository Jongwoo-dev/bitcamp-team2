package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherAddController implements Command {
  private TeacherDao teacherDao;

  public TeacherAddController() {
    teacherDao = TeacherDao.getInstance();
  }

  // teacher/add?userid=hong&password=1234&name=홍길동&email=hong@test.com&tel=111-1111&age=39&subject=자바&carrer=10&salary=8500&address=서울
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (teacherDao.existUserId(paramMap.get("userid"))) {
      out.println("같은 아이디가 존재합니다. 등록을 취소합니다.");
      return;
    }
    
    Teacher teacher = new Teacher();
    teacher.setUserId(paramMap.get("userid"));
    teacher.setPassword(paramMap.get("password"));
    teacher.setName(paramMap.get("name"));
    teacher.setEmail(paramMap.get("email"));
    teacher.setTel(paramMap.get("tel"));
    teacher.setAge(Integer.parseInt(paramMap.get("age")));
    teacher.setSubject(paramMap.get("subject"));
    teacher.setCarrer(Integer.parseInt(paramMap.get("carrer")));
    teacher.setSalary(Integer.parseInt(paramMap.get("salary")));
    teacher.setAddress(paramMap.get("address"));

    teacherDao.insert(teacher);
    out.println("등록하였습니다.");
  }
}
