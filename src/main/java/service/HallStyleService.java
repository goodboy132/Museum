package service;

import entity.HallStyle;

import java.util.List;
import java.util.Optional;

public interface HallStyleService {
  int save(HallStyle hallStyle);
  Optional<HallStyle> getById(Long id);
  int update(HallStyle hallStyle);
  int delete(HallStyle hallStyle);
  List<HallStyle> getAll();
}
