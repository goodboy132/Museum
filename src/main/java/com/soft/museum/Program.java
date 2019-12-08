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

    LocalDateTime t1 = LocalDateTime.of(1990, 1 , 1 , 1, 1);
    LocalDateTime t2 = LocalDateTime.of(1991, 1 , 1 , 1, 1);

    try {
      System.out.println(ServiceFactory.getInstance().getExcursionService().getAvailableExcursionsForPeriod(t1, t2));
    } catch (NotFoundException e) {
      e.printStackTrace();
    }

  }
}
