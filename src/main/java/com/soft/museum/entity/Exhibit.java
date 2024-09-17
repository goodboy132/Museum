package com.soft.museum.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data

public class Exhibit {
  private Long id;
  private String name;
  private LocalDateTime receiptDate;
  private String description;
  private Author author;
  private Hall hall;
  private List<Material> materials;
  private List<Technique> techniques;
}
