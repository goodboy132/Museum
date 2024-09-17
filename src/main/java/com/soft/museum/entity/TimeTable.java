package com.soft.museum.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeTable {
  private Long id;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
}
