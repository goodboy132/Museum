package dao;

import entity.Author;
import entity.Exhibit;

import java.util.List;
import java.util.Map;

public interface ExhibitDAO extends GenericDAO<Exhibit> {
  List<Exhibit>getAllByAuthor(Long authorId);
  List<Exhibit>getAllByWorker(Long workerId);
  List<Exhibit>getAllByHole(Long workerId);
  Map<String,Integer>getStatisticByMaterial();
  Map<String,Integer>getStatisticByTechnique();
  Map<String,Integer> getStatisticByAuthor();
  Map<String,Integer> getStatisticByHall();
}
