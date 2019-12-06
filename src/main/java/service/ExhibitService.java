package service;


import entity.Author;
import entity.Exhibit;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ExhibitService {
  int save(Exhibit exhibit);
  int update(Exhibit exhibit);
  int delete(Exhibit exhibit);
  Optional<Exhibit> getById(Long id);
  List<Exhibit> getAll();
  List<Exhibit> getAllByAuthor(Long id);
  List<Exhibit> getAllByWorker(Long id);
  List<Exhibit> getAllByHall(Long id);
  Map<String,Integer> getStatisticByMaterial();
  Map<String,Integer> getStatisticByTechnique();
  Map<String,Integer> getStatisticByAuthor();
  Map<String,Integer> getStatisticByHall();
}
