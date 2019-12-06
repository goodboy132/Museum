package entity;

import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

@Data

public class Author {
  private Long id;
  private String firstName;
  private String lastName;
  private LocalDateTime bornDate;
  private LocalDateTime deathDate;

  @Override
  public String toString() {
    return "Author{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", bornDate=" + bornDate +
            ", deathDate=" + deathDate +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Author author = (Author) o;
    return Objects.equals(id, author.id) &&
            Objects.equals(firstName, author.firstName) &&
            Objects.equals(lastName, author.lastName) &&
            Objects.equals(bornDate, author.bornDate) &&
            Objects.equals(deathDate, author.deathDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, bornDate, deathDate);
  }

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

  public LocalDateTime getBornDate() {
    return bornDate;
  }

  public void setBornDate(LocalDateTime bornDate) {
    this.bornDate = bornDate;
  }

  public LocalDateTime getDeathDate() {
    return deathDate;
  }

  public void setDeathDate(LocalDateTime deathDate) {
    this.deathDate = deathDate;
  }
}
