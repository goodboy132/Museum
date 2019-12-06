package entity;

import lombok.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class TimeTable {
  private Long id;
  private LocalDateTime startTime;
  private LocalDateTime endTime;

  @Override
  public String toString() {
    return "TimeTable{" +
            "id=" + id +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TimeTable timeTable = (TimeTable) o;
    return Objects.equals(id, timeTable.id) &&
            Objects.equals(startTime, timeTable.startTime) &&
            Objects.equals(endTime, timeTable.endTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, startTime, endTime);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }
}
