package entity;

import entity.enums.WorkerPositions;
import lombok.*;

import java.util.Objects;

@Data
public class WorkerPosition {
  private Long id;
  private WorkerPositions positionName;

  @Override
  public String toString() {
    return "WorkerPosition{" +
            "id=" + id +
            ", positionName=" + positionName +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WorkerPosition that = (WorkerPosition) o;
    return Objects.equals(id, that.id) &&
            positionName == that.positionName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, positionName);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public WorkerPositions getPositionName() {
    return positionName;
  }

  public void setPositionName(WorkerPositions positionName) {
    this.positionName = positionName;
  }
}
