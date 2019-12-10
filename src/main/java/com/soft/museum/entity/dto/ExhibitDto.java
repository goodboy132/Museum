package com.soft.museum.entity.dto;

import com.soft.museum.entity.Material;
import com.soft.museum.entity.Technique;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExhibitDto {
  private Long id;
  private String exhibitName;
  private String description;
  private AuthorDto authorDto;
}
