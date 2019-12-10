package com.soft.museum.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorDto {
  private Long id;
  private String authorName;
  private String authorSurname;
}
