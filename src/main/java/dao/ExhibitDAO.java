package dao;

import entity.Author;
import entity.Exhibit;

import java.util.List;

public interface ExhibitDAO extends GenericDAO<Exhibit> {
  List<Exhibit>getAllByAuthor(int authorId);
  List<Exhibit>getAllByWorker(int workerId);
}
