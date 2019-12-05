package dao;

import entity.Author;
import entity.Exhibit;

import java.util.List;

public interface ExhibitDAO extends GenericDAO<Exhibit> {
  List<Exhibit>getAllByAuthor(Long authorId);
  List<Exhibit>getAllByWorker(Long workerId);
  List<Exhibit>getAllByHole(Long workerId);
}
