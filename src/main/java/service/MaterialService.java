package service;

import entity.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialService {
  int save(Material material);
  int update(Material material);
  int delete(Material material);
  Optional<Material> getById(Long id);
  List<Material> getAll();
}
