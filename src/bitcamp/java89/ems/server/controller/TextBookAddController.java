package bitcamp.java89.ems.server.controller;
import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TextBookDao;
import bitcamp.java89.ems.server.vo.TextBook;

public class TextBookAddController implements Command {
  private TextBookDao textBookDao;

  public TextBookAddController() {
    textBookDao = TextBookDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (textBookDao.existTitle(paramMap.get("title"))) {
      out.println("같은 책제목이 존재합니다. 등록을 취소합니다.");
      return;
    }

    TextBook textBook = new TextBook();
    textBook.setTitle(paramMap.get("title"));
    textBook.setAuthor(paramMap.get("author"));
    textBook.setPress(paramMap.get("press"));
    textBook.setReleaseDate(paramMap.get("releaseDate"));
    textBook.setLanguage(paramMap.get("language"));
    textBook.setDescription(paramMap.get("description"));

    textBookDao.insert(textBook);
    out.println("등록하였습니다.");
  }

}


