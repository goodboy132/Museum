package entity;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data

public class Exhibit {
  private Long id;
  private String name;
  private LocalDateTime receiptDate;
  private String technique;
  private String description;

  private Author author;
  private Hall hall;
  private List<Material> materials;

  @Override
  public String toString() {
    return "Exhibit{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", receiptDate=" + receiptDate +
            ", technique='" + technique + '\'' +
            ", description='" + description + '\'' +
            ", author=" + author +
            ", hall=" + hall +
            ", materials=" + materials +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Exhibit exhibit = (Exhibit) o;
    return Objects.equals(id, exhibit.id) &&
            Objects.equals(name, exhibit.name) &&
            Objects.equals(receiptDate, exhibit.receiptDate) &&
            Objects.equals(technique, exhibit.technique) &&
            Objects.equals(description, exhibit.description) &&
            Objects.equals(author, exhibit.author) &&
            Objects.equals(hall, exhibit.hall) &&
            Objects.equals(materials, exhibit.materials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, receiptDate, technique, description, author, hall, materials);
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

  public LocalDateTime getReceiptDate() {
    return receiptDate;
  }

  public void setReceiptDate(LocalDateTime receiptDate) {
    this.receiptDate = receiptDate;
  }

  public String getTechnique() {
    return technique;
  }

  public void setTechnique(String technique) {
    this.technique = technique;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Hall getHall() {
    return hall;
  }

  public void setHall(Hall hall) {
    this.hall = hall;
  }

  public List<Material> getMaterials() {
    return materials;
  }

  public void setMaterials(List<Material> materials) {
    this.materials = materials;
  }
}
