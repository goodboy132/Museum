package service.impl;

import dao.ExhibitDAO;
import dao.databace.Database;
import dao.impl.JDBCAuthorDao;
import dao.impl.JDBCExhibitDAO;
import entity.Author;
import entity.Exhibit;
import service.ExhibitService;

import java.util.List;
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
    return Optional.empty();
  }

  @Override
  public List<Exhibit> getAll() {
    return exhibitDAO.getAll();
  }

  @Override
  public List<Exhibit> getAllByAuthor(int authorId) {
    return exhibitDAO.getAllByAuthor(authorId);
  }
}
