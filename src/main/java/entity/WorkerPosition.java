package entity;

import entity.enums.WorkerPositions;
import lombok.Data;

import java.util.Objects;

@Data
public class WorkerPosition {
  private Long id;
  private WorkerPositions positionName;
}
