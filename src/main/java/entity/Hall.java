package entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data

public class Hall {
  private Long id;
  private String name;

  private HallStyle hallStyle;

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

  public HallStyle getHallStyle() {
    return hallStyle;
  }

  public void setHallStyle(HallStyle hallStyle) {
    this.hallStyle = hallStyle;
  }

  @Override
  public String toString() {
    return "Hall{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", hallStyle=" + hallStyle +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Hall hall = (Hall) o;
    return Objects.equals(id, hall.id) &&
            Objects.equals(name, hall.name) &&
            Objects.equals(hallStyle, hall.hallStyle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, hallStyle);
  }
}
