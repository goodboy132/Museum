package com.soft.museum.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorDto {
  private Long id;
  private String authorName;
  private String authorSurname;
}
