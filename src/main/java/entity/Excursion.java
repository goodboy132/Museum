package entity;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Data

public class Excursion {
  private Long id;
  private String name;
  private String program;
  private Worker worker;

  List<TimeTable> timeTables;

  @Override
  public String toString() {
    return "Excursion{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", program='" + program + '\'' +
            ", worker=" + worker +
            ", timeTables=" + timeTables +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Excursion excursion = (Excursion) o;
    return Objects.equals(id, excursion.id) &&
            Objects.equals(name, excursion.name) &&
            Objects.equals(program, excursion.program) &&
            Objects.equals(worker, excursion.worker) &&
            Objects.equals(timeTables, excursion.timeTables);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, program, worker, timeTables);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProgram() {
    return program;
  }

  public void setProgram(String program) {
    this.program = program;
  }

  public Worker getWorker() {
    return worker;
  }

  public void setWorker(Worker worker) {
    this.worker = worker;
  }

  public List<TimeTable> getTimeTables() {
    return timeTables;
  }

  public void setTimeTables(List<TimeTable> timeTables) {
    this.timeTables = timeTables;
  }
}
