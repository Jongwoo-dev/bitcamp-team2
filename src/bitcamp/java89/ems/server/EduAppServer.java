package bitcamp.java89.ems.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

import bitcamp.java89.ems.server.controller.ContactAddController;
import bitcamp.java89.ems.server.controller.ContactDeleteController;
import bitcamp.java89.ems.server.controller.ContactListController;
import bitcamp.java89.ems.server.controller.ContactUpdateController;
import bitcamp.java89.ems.server.controller.ContactViewController;
import bitcamp.java89.ems.server.controller.LectureAddController;
import bitcamp.java89.ems.server.controller.LectureDeleteController;
import bitcamp.java89.ems.server.controller.LectureListController;
import bitcamp.java89.ems.server.controller.LectureUpdateController;
import bitcamp.java89.ems.server.controller.LectureViewController;
import bitcamp.java89.ems.server.controller.TeacherAddController;
import bitcamp.java89.ems.server.controller.TeacherDeleteController;
import bitcamp.java89.ems.server.controller.TeacherListController;
import bitcamp.java89.ems.server.controller.TeacherUpdateController;
import bitcamp.java89.ems.server.controller.TeacherViewController;
import bitcamp.java89.ems.server.controller.TextBookAddController;
import bitcamp.java89.ems.server.controller.TextBookDeleteController;
import bitcamp.java89.ems.server.controller.TextBookListController;
import bitcamp.java89.ems.server.controller.TextBookUpdateController;
import bitcamp.java89.ems.server.controller.TextBookViewController;

public class EduAppServer {
  // Command 구현체 보관소
  // => HashMap<명령문자열,요청처리객체> commandMap
  HashMap<String, Command> commandMap = new HashMap<>();

  public EduAppServer() {
    // 클라이언트 요청을 처리할 command 구현체를 준비한다.
    commandMap.put("contact/list", new ContactListController());
    commandMap.put("contact/view", new ContactViewController());
    commandMap.put("contact/add", new ContactAddController());
    commandMap.put("contact/delete", new ContactDeleteController());
    commandMap.put("contact/update", new ContactUpdateController());
    
    commandMap.put("teacher/list", new TeacherListController());
    commandMap.put("teacher/view", new TeacherViewController());
    commandMap.put("teacher/add", new TeacherAddController());
    commandMap.put("teacher/delete", new TeacherDeleteController());
    commandMap.put("teacher/update", new TeacherUpdateController());

    commandMap.put("textBook/add", new TextBookAddController());
    commandMap.put("textBook/list", new TextBookListController());
    commandMap.put("textBook/view", new TextBookViewController());
    commandMap.put("textBook/delete", new TextBookDeleteController());
    commandMap.put("textBook/update", new TextBookUpdateController());
    
    commandMap.put("lecture/add", new LectureAddController());
    commandMap.put("lecture/list", new LectureListController());
    commandMap.put("lecture/view", new LectureViewController());
    commandMap.put("lecture/delete", new LectureDeleteController());
    commandMap.put("lecture/update", new LectureUpdateController());
  }

  private void service() throws IOException {
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버 실행 중...");

    while (true) {
      new RequestThread(ss.accept(), commandMap).start();
    }
  }

  public static void main(String[] args) throws Exception {
    EduAppServer eduAppServer = new EduAppServer();
    eduAppServer.service();
  }
}
