package com.soft.museum;

import com.soft.museum.entity.Author;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.service.ServiceFactory;

import java.time.LocalDateTime;

public class Program {
  public static void main(String[] args) {
    Author author = new Author();
    author.setFirstName("pavlo");
    author.setLastName("baluh");
    author.setBornDate(LocalDateTime.now());
    author.setDeathDate(LocalDateTime.now());
    try {
      System.out.println(ServiceFactory.getInstance().getExhibitService().getById(2L));
    } catch (NotFoundException e) {
      e.printStackTrace();
    }
  }
}
