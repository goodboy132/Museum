package service;

import entity.Hall;

import java.util.List;
import java.util.Optional;

public interface HallService {
  int save(Hall hall);
  int update(Hall hall);
  int delete(Hall hall);
  Optional<Hall> getById(Long id);
  List<Hall> getAll();
}
