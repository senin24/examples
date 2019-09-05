package com.github.senin24.examples.files;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFilesInClassPath {

//  public static void main(){
//    String content = getFileContent(ReadFilesInClassPath.getClass(), "application.properties");
//    System.out.println(content);
//  }


  public static String getFileContent(Class<?> callerClass, String path) {
    ClassLoader classLoader = callerClass.getClassLoader();
    try {
      return new String(Files.readAllBytes(Paths.get(classLoader.getResource(path).toURI())));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
