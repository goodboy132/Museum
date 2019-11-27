package dao;

import java.util.List;

public class ElementDAOImpl <E> implements ElementDAO{
  private Class<E> elementClass;

  public ElementDAOImpl(Class<E> elementClass) {
    this.elementClass = elementClass;
  }

  public void save(Object element) {

  }

  public void update(Object element) {

  }

  public void delete(Object element) {

  }

  public Object getOneById(Long elementId) {
    return null;
  }

  public List getAll() {
    return null;
  }
}
