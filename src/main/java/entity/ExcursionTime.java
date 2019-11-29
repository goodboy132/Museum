package entity;

import lombok.Data;

import java.sql.Time;


@Data

public class ExcursionTime {
  private Long id;
  private Time startTime;
  private Time endTime;

}
