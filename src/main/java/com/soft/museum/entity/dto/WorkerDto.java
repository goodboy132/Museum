package com.soft.museum.entity.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkerDto {
  private Long id;
  private String firstName;
  private String lastName;
}
