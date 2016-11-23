package bitcamp.java89.ems.server.dao;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitcamp.java89.ems.server.vo.TextBook;

public class TextBookDao {
  static TextBookDao obj;
  private String filename = "book-v1.7.data";
  private ArrayList<TextBook> list;



  public static TextBookDao getInstance() {
    if (obj == null) {
      obj = new TextBookDao();
    }
    return obj;
  }

  private TextBookDao() {
    this.load();
  }



  @SuppressWarnings("unchecked")
  private void load() {
    FileInputStream in0 = null;
    ObjectInputStream in = null;

    try {
      in0 = new FileInputStream(this.filename);
      in = new ObjectInputStream(in0);

      list = (ArrayList<TextBook>)in.readObject();

    } catch (EOFException e) {
      // 파일을 모두 읽었다.
    } catch (Exception e) {
   
      System.out.println("데이터 로딩 중 오류 발생!");
      list = new ArrayList<>();

    } finally {
      try {
        in.close();
        in0.close();
      } catch (Exception e) {}
    }
  }

  public void save() throws Exception {
    FileOutputStream out0 = new FileOutputStream(this.filename);
    ObjectOutputStream out = new ObjectOutputStream(out0);

    out.writeObject(list);

    out.close();
    out0.close();
  }

  public ArrayList<TextBook> getList() {
    return this.list;
  }

  public ArrayList<TextBook> getListByName(String title) {
    ArrayList<TextBook> results = new ArrayList<>();
    for (TextBook textBook : list) {
      if (textBook.getTitle().equals(title)) {
        results.add(textBook);
      }
    }
    return results;
  }

  synchronized public void insert(TextBook textBook) {
    list.add(textBook);
    try {this.save();} catch (Exception e) {}
  }

  synchronized public void update(TextBook textBook) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getTitle().equals(textBook.getTitle())) {
        list.set(i, textBook);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }

  synchronized public void delete(String title) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getTitle().equals(title)) {
        list.remove(i);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }

  public boolean existTitle(String title) {
    for (TextBook textBook : list) {
      System.out.println(textBook.getTitle()+"   "+title);
      if (textBook.getTitle().toLowerCase().equals(title.toLowerCase())) {
        return true;
      }
    }
    return false;
  }
}