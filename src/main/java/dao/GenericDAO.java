package dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<E> {
  Integer save(E element);
  void update(E element);
  void delete(E element);
  Optional<E> getOneById(Long elementId);
  List<E> getAll();
}
