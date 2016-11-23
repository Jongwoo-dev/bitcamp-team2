package bitcamp.java89.ems.server.controller;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TextBookDao;
import bitcamp.java89.ems.server.vo.TextBook;

public class TextBookViewController implements Command {
  private TextBookDao textBookDao;

  public TextBookViewController() {
    textBookDao = TextBookDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<TextBook> list = textBookDao.getListByName(paramMap.get("title"));
    for (TextBook textBook : list) {
      out.println("--------------------------");
      out.printf("책제목: %s\n", textBook.getTitle());
      out.printf("작가: %s\n", textBook.getAuthor());
      out.printf("인쇄: %s\n", textBook.getPress());
      out.printf("출판일: %s\n", textBook.getReleaseDate());
      out.printf("언어: %s\n", textBook.getLanguage());
      out.printf("종류: %s\n", textBook.getDescription());
    }
  }
}


