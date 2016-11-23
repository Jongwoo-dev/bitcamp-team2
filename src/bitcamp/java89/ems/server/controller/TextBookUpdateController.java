package bitcamp.java89.ems.server.controller;
import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TextBookDao;
import bitcamp.java89.ems.server.vo.TextBook;

public class TextBookUpdateController implements Command {
  private TextBookDao textBookDao;

  public TextBookUpdateController() {
    textBookDao = TextBookDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!textBookDao.existTitle(paramMap.get("email"))) {
      out.println("책을 찾지 못했습니다.");
      return;
    }

    TextBook textBook = new TextBook();
    textBook.setTitle(paramMap.get("title"));
    textBook.setAuthor(paramMap.get("author"));
    textBook.setPress(paramMap.get("press"));
    textBook.setReleaseDate(paramMap.get("releaseDate"));
    textBook.setLanguage(paramMap.get("language"));
    textBook.setDescription(paramMap.get("description"));

    textBookDao.update(textBook);
    out.println("변경 하였습니다.");
  }
}


