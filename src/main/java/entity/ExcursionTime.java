package entity;

import lombok.Data;

import java.sql.Time;
import java.util.Objects;

@Data

public class ExcursionTime {
  private Long id;
  private Time startTime;
  private Time endTime;

  @Override
  public String toString() {
    return "ExcursionTime{" +
            "id=" + id +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExcursionTime that = (ExcursionTime) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(startTime, that.startTime) &&
            Objects.equals(endTime, that.endTime);
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

  public Time getStartTime() {
    return startTime;
  }

  public void setStartTime(Time startTime) {
    this.startTime = startTime;
  }

  public Time getEndTime() {
    return endTime;
  }

  public void setEndTime(Time endTime) {
    this.endTime = endTime;
  }
}
