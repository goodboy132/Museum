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
    author.setId(2L);
    author.setFirstName("pavlo");
    author.setLastName("baluh");
    author.setBornDate(LocalDateTime.now());
    author.setDeathDate(LocalDateTime.now());

    LocalDateTime t1 = LocalDateTime.of(1990, 1 , 1 , 1, 1);
    LocalDateTime t2 = LocalDateTime.of(1991, 1 , 1 , 1, 1);
    WorkerPosition workerPosition = new WorkerPosition();
    workerPosition.setId(1L);

    Worker worker = new Worker();
    worker.setId(3L);
    worker.setFirstName("Max");
    worker.setLastName("Green");
    worker.setWorkerPosition(workerPosition);
    worker.setLogin("green_max");
    worker.setPassword("pass");

    HallStyle hallStyle = new HallStyle();
    hallStyle.setId(2L);
    hallStyle.setName("nature");

    Hall hall = new Hall();
    hall.setId(200L);
    hall.setName("^^^");
    hall.setHallStyle(hallStyle);

    Excursion excursion = new Excursion();
    excursion.setId(3L);
    excursion.setName("name");
    excursion.setProgram("bla-bla");
    excursion.setWorker(worker);

    Technique technique = new Technique();
    technique.setId(1L);

    Exhibit exhibit = new Exhibit();
    exhibit.setId(500L);
    exhibit.setName("update");
    exhibit.setReceiptDate(LocalDateTime.now());
    exhibit.setTechnique(technique);
    exhibit.setDescription("update");
    exhibit.setAuthor(author);
    exhibit.setHall(hall);

    Material material = new Material();
    material.setId(400L);
    material.setName("Fire");

    try {
      System.out.println(ServiceFactory.getInstance().getWorkerService().update(worker));
    } catch (NotUpdatedException e) {
      e.printStackTrace();
    }

  }
}
