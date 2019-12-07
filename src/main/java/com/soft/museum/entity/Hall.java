package com.soft.museum.entity;

import lombok.Data;

@Data

public class Hall {
  private Long id;
  private String name;
  private HallStyle hallStyle;
}
