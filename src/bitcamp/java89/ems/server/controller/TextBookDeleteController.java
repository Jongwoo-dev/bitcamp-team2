package bitcamp.java89.ems.server.controller;
import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TextBookDao;

public class TextBookDeleteController implements Command {
  private TextBookDao textBookDao;

  public TextBookDeleteController() {
    textBookDao = TextBookDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!textBookDao.existTitle(paramMap.get("title"))) {
      out.println("해당 데이터가 없습니다.");
      return;
    }

    textBookDao.delete(paramMap.get("title"));
    out.println("해당 데이터를 삭제 완료하였습니다.");
  }
}


