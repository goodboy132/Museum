package com.soft.museum.service;

import com.soft.museum.entity.Material;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.util.List;
import java.util.Optional;

public interface MaterialService {
  int save(Material material) throws NotSavedException;
  int update(Material material) throws NotUpdatedException;
  int delete(Material material) throws NotDeletedException;
  Optional<Material> getById(Long id) throws NotFoundException;
  List<Material> getAll() throws NotFoundException;
}
