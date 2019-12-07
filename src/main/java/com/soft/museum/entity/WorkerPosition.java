package com.soft.museum.entity;

import com.soft.museum.entity.enums.WorkerPositions;
import lombok.Data;

@Data
public class WorkerPosition {
  private Long id;
  private WorkerPositions positionName;
}
