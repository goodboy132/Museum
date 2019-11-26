package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Worker {
  private Long id;
  private String firstName;
  private String lastName;
  private String patronimic;

  private List<Hall> halls = new ArrayList<Hall>();
  private WorkerPosition workerPosition;
}
