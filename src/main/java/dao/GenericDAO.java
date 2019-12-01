package dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<E> {
  Integer save(E element);
  Integer update(E element);
  Integer delete(E element);
  Optional<E> getOneById(Long elementId);
  List<E> getAll();
}
