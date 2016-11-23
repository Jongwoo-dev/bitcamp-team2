package bitcamp.java89.ems.server.controller;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TextBookDao;
import bitcamp.java89.ems.server.vo.TextBook;

public class TextBookListController implements Command {
  private TextBookDao textBookDao;

  public TextBookListController() {
    textBookDao = TextBookDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<TextBook> list = textBookDao.getList();
    for (TextBook textBook : list) {
      out.printf("%s,%s,%s,%s\n",
          textBook.getTitle(),
          textBook.getAuthor(),
          textBook.getPress(),
          textBook.getReleaseDate(),
          textBook.getLanguage(),
          textBook.getDescription());
    }
  }
}


