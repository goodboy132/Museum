package entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data

public class Worker {
  private Long id;
  private String firstName;
  private String lastName;
  private String login;
  private String password;
  private WorkerPosition workerPosition;
  private List<Hall> halls;
  private List<Excursion> excursions;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public WorkerPosition getWorkerPosition() {
    return workerPosition;
  }

  public void setWorkerPosition(WorkerPosition workerPosition) {
    this.workerPosition = workerPosition;
  }

  public List<Hall> getHalls() {
    return halls;
  }

  public void setHalls(List<Hall> halls) {
    this.halls = halls;
  }

  public List<Excursion> getExcursions() {
    return excursions;
  }

  public void setExcursions(List<Excursion> excursions) {
    this.excursions = excursions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Worker worker = (Worker) o;
    return Objects.equals(id, worker.id) &&
            Objects.equals(firstName, worker.firstName) &&
            Objects.equals(lastName, worker.lastName) &&
            Objects.equals(login, worker.login) &&
            Objects.equals(password, worker.password) &&
            Objects.equals(workerPosition, worker.workerPosition) &&
            Objects.equals(halls, worker.halls) &&
            Objects.equals(excursions, worker.excursions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, login, password, workerPosition, halls, excursions);
  }

  @Override
  public String toString() {
    return "Worker{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", workerPosition=" + workerPosition +
            ", halls=" + halls +
            ", excursions=" + excursions +
            '}';
  }
}
