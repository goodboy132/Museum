package com.soft.museum.service;

import com.soft.museum.entity.HallStyle;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.util.List;
import java.util.Optional;

public interface HallStyleService {
  int save(HallStyle hallStyle) throws NotSavedException;
  Optional<HallStyle> getById(Long id) throws NotFoundException;
  int update(HallStyle hallStyle) throws NotUpdatedException;
  int delete(HallStyle hallStyle) throws NotDeletedException;
  List<HallStyle> getAll() throws NotFoundException;
}
