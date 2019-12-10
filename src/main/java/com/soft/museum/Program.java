package com.soft.museum;

import com.soft.museum.entity.*;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;
import com.soft.museum.service.ServiceFactory;

import java.time.LocalDateTime;

public class Program {
  public static void main(String[] args) {
    Author author = new Author();
    author.setId(4L);
    author.setFirstName("Taras");
    author.setLastName("Shevchenko");
    author.setBornDate(LocalDateTime.now());
    author.setDeathDate(LocalDateTime.now());

//    LocalDateTime t1 = LocalDateTime.of(1990, 1 , 1 , 1, 1);
//    LocalDateTime t2 = LocalDateTime.of(1991, 1 , 1 , 1, 1);
//    WorkerPosition workerPosition = new WorkerPosition();
//    workerPosition.setId(1L);
//
//    Worker worker = new Worker();
//    worker.setFirstName("Jim");
//    worker.setLastName("white");
//    worker.setWorkerPosition(workerPosition);
//    worker.setLogin("white_jim");
//    worker.setPassword("12345");
//
//    HallStyle hallStyle = new HallStyle();
//    hallStyle.setName("wild nature");
//
//    Hall hall = new Hall();
//    hall.setId(200L);
//    hall.setName("Good hall");
//    hall.setHallStyle(hallStyle);
//
//    Excursion excursion = new Excursion();
//    excursion.setId(3L);
//    excursion.setName("Water fall");
//    excursion.setProgram("We will see great water fall");
//    excursion.setWorker(worker);
//
//    Technique technique = new Technique();
//    technique.setId(1L);
//
//    Exhibit exhibit = new Exhibit();
//    exhibit.setName("Round stone");
//    exhibit.setReceiptDate(LocalDateTime.now());
//    exhibit.setTechnique(technique);
//    exhibit.setDescription("Nice exhibit");
//    exhibit.setAuthor(author);
//    exhibit.setHall(hall);
//
//    Material material = new Material();
//    material.setName("Plastic");
//
//    try {
//      System.out.println(ServiceFactory.getInstance().getWorkerService().save(worker));
//    } catch (NotSavedException e) {
//      e.printStackTrace();
//    }

  }
}
