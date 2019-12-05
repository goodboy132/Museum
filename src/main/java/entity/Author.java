package entity;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

@Data

public class Author {
  private Long id;
  private String firstName;
  private String lastName;
  private LocalDateTime bornDate;
  private LocalDateTime deathDate;
}
