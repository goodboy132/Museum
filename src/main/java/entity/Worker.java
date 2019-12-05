package entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
