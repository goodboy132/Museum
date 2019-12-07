package com.soft.museum.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Author {
  private Long id;
  private String firstName;
  private String lastName;
  private LocalDateTime bornDate;
  private LocalDateTime deathDate;
}
