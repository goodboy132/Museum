package entity;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

@Data

public class ExcursionTime {
  private Long id;
  private LocalDateTime startTime;
  private LocalDateTime endTime;

}
