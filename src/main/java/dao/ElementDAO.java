package dao;

import java.util.List;

public interface ElementDAO<E> {
  void save(E element);
  void update(E element);
  void delete(E element);
  E getOneById(Long elementId);
  List<E> getAll();
}
