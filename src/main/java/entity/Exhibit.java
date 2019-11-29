package entity;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data

public class Exhibit {
  private Long id;
  private String name;
  private LocalDateTime receiptDate;
  private String technique;
  private String description;

  private Author author;
  private Hall hall;
  private List<Material> materials;
}
