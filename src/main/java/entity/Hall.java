package entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data

public class Hall {
  private Long id;
  private String name;
  private HallStyle hallStyle;
}
