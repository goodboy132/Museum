package entity;

import lombok.Data;

@Data

public class Excursion {
  private Long id;
  private String name;
  private String program;
  private String timeTable;

  private Worker worker;
  private ExcursionDate excursionDate;
}
