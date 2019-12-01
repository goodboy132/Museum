package service.impl;

import dao.ExhibitDAO;
import dao.databace.Database;
import dao.impl.JDBCAuthorDao;
import dao.impl.JDBCExhibitDAO;
import entity.Exhibit;
import service.ExhibitService;

import java.util.List;

public class ExhibitServiceImpl implements ExhibitService {
  private ExhibitDAO exhibitDAO;

  ExhibitServiceImpl() {
    exhibitDAO = JDBCExhibitDAO.getInstance(Database.getConnection());
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
