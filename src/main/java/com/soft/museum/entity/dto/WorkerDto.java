package com.soft.museum.entity.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkerDto {
  private Long id;
  private String firstName;
  private String lastName;
}
