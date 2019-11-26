package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Exhibition {
  private Long id;
  private String name;
  private Date receiptDate;
  private String technique;
  private String description;

  private Author author;
  private Hall hall;
  private List<Material> materials = new ArrayList<Material>();
}
