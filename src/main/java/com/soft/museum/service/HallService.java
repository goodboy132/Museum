package com.soft.museum.service;

import com.soft.museum.entity.Hall;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.util.List;
import java.util.Optional;

public interface HallService {
  int save(Hall hall) throws NotSavedException;
  int update(Hall hall) throws NotUpdatedException;
  int delete(Hall hall) throws NotDeletedException;
  Optional<Hall> getById(Long id) throws NotFoundException;
  List<Hall> getAll() throws NotFoundException;
}
