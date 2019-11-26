package entity;

import lombok.Data;

import java.sql.Date;

@Data

public class Author {
  private Long id;
  private String firstName;
  private String lastName;
  private Date bornDate;
  private Date deathDate;
}
