package entity;

import lombok.Data;

import java.util.Objects;

@Data

public class Material {
  private Long id;
  private String name;

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

  @Override
  public String toString() {
    return "Material{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Material material = (Material) o;
    return Objects.equals(id, material.id) &&
            Objects.equals(name, material.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
