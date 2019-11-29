package entity;

import lombok.Data;

import java.util.Objects;

@Data

public class Excursion {
  private Long id;
  private String name;
  private String program;
  private String timeTable;
  private Worker worker;
  private ExcursionTime excursionDate;

  @Override
  public String toString() {
    return "Excursion{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", program='" + program + '\'' +
            ", timeTable='" + timeTable + '\'' +
            ", worker=" + worker +
            ", excursionDate=" + excursionDate +
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
            Objects.equals(timeTable, excursion.timeTable) &&
            Objects.equals(worker, excursion.worker) &&
            Objects.equals(excursionDate, excursion.excursionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, program, timeTable, worker, excursionDate);
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

  public String getTimeTable() {
    return timeTable;
  }

  public void setTimeTable(String timeTable) {
    this.timeTable = timeTable;
  }

  public Worker getWorker() {
    return worker;
  }

  public void setWorker(Worker worker) {
    this.worker = worker;
  }

  public ExcursionTime getExcursionDate() {
    return excursionDate;
  }

  public void setExcursionDate(ExcursionTime excursionDate) {
    this.excursionDate = excursionDate;
  }
}
