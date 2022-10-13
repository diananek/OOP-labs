package lab4;

import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
  public static void  readFile(String fileName) {
   
    try {
   
      FileReader reader = new FileReader(fileName);
      char[] buffer = new char[8096];
     
      int chars = reader.read(buffer);
     
      while (chars != -1) {
        System.out.println(String.valueOf(buffer, 0, chars));
        chars = reader.read(buffer);
      }
      reader.close();
   
    } catch (IOException e) {
      e.printStackTrace();
    }
   
  }
 
  public static void main(String[] args) {
    readFile("D:/Образование/University/ООП/OOP-labs/lab4/data.txt");
  }

}
