package service.impl;

import dao.ExhibitDAO;
import dao.databace.Database;
import dao.impl.JDBCAuthorDao;
import dao.impl.JDBCExhibitDAO;
import entity.Author;
import entity.Exhibit;
import service.ExhibitService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExhibitServiceImpl implements ExhibitService {
  private ExhibitDAO exhibitDAO;

  ExhibitServiceImpl() {
    exhibitDAO = JDBCExhibitDAO.getInstance(Database.getConnection());
  }


  @Override
  public int save(Exhibit exhibit) {
    return exhibitDAO.save(exhibit);
  }

  @Override
  public int update(Exhibit exhibit) {
    return exhibitDAO.update(exhibit);
  }

  @Override
  public int delete(Exhibit exhibit) {
    return exhibitDAO.delete(exhibit);
  }

  @Override
  public Optional<Exhibit> getById(Long id) {   //need to make get by id
    return exhibitDAO.getOneById(id);
  }

  @Override
  public List<Exhibit> getAll() {
    return exhibitDAO.getAll();
  }

  @Override
  public List<Exhibit> getAllByAuthor(Long authorId) {
    return exhibitDAO.getAllByAuthor(authorId);
  }

  @Override
  public List<Exhibit> getAllByWorker(Long workerId) {
    return exhibitDAO.getAllByWorker(workerId);
  }

  @Override
  public List<Exhibit> getAllByHall(Long hallId) {
    return exhibitDAO.getAllByHole(hallId);
  }

  @Override
  public Map<String, Integer> getStatisticByMaterial() {
    return exhibitDAO.getStatisticByMaterial();
  }
}
