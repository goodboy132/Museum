package entity;

import lombok.Data;

import java.sql.Time;

@Data

public class ExcursionDate {
  private Long id;
  private Time startTime;
  private Time endTime;
}
