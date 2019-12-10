package com.soft.museum.exception;

import java.io.*;
import java.time.LocalDateTime;

public class ExceptionLogger {
  private static ExceptionLogger instance;
  private String passToFile = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Museum"
          + File.separator + "src" + File.separator +
          "main" + File.separator + "java" + File.separator + "com" + File.separator + "soft" + File.separator +
          "museum" + File.separator + "exception" + File.separator + "Exceptions.txt";


  public static synchronized ExceptionLogger getInstance() {
    if (instance == null) {
      instance = new ExceptionLogger();
    }
    return instance;
  }


  public void log(String exception) {
    File file = new File(passToFile);
    System.out.println(passToFile);
    System.out.println(file);
    try {
      if (!file.exists()) {
        file.createNewFile();
      }
      OutputStream outputStream = new FileOutputStream(file, true);
      PrintWriter printWriter = new PrintWriter(outputStream);
      printWriter.write(LocalDateTime.now() + " " + exception + "\n");
      printWriter.close();
    }
    catch (IOException e){
      e.printStackTrace();
      throw new RuntimeException();
    }
  }


  public String getPassToFile() {
    return passToFile;
  }

  public void setPassToFile(String passToFile) {
    this.passToFile = passToFile;
  }

}
