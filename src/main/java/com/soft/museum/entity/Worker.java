package com.soft.museum.entity;

import lombok.Data;

import java.util.List;

@Data

public class Worker {
  private Long id;
  private String firstName;
  private String lastName;
  private String login;
  private String password;
  private WorkerPosition workerPosition;
  private List<Hall> halls;
  private List<Excursion> excursions;
}
