package service;


import entity.Exhibit;

import java.util.List;

public interface ExhibitService {
  List<Exhibit> getAll();
  List<Exhibit> getAllByAuthor(int id);
}
