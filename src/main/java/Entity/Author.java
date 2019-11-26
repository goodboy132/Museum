package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Author {
  private Long id;
  private String firstName;
  private String lastName;
  private String patronimic;
  private Date bornDate;
  private Date deathDate;
}
