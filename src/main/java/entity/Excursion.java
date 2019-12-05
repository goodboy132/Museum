package entity;

import lombok.Data;

import java.util.List;

@Data

public class Excursion {
  private Long id;
  private String name;
  private String program;
  private Worker worker;
  private List<TimeTable> excursionTime;
}
