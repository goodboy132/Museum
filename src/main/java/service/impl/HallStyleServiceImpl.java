package service.impl;

import dao.HallStyleDAO;
import dao.databace.Database;
import dao.impl.JDBCHallStyleDAO;
import entity.HallStyle;
import service.HallStyleService;

import java.util.List;
import java.util.Optional;

public class HallStyleServiceImpl implements HallStyleService {
  private HallStyleDAO hallStyleDAO;

  HallStyleServiceImpl() {
    hallStyleDAO = JDBCHallStyleDAO.getInstance(Database.getConnection());
  }


  @Override
  public int save(HallStyle hallStyle) {
    return hallStyleDAO.save(hallStyle);
  }

  @Override
  public Optional<HallStyle> getById(Long id) {
    return hallStyleDAO.getOneById(id);
  }

  @Override
  public int update(HallStyle hallStyle) {
    return hallStyleDAO.update(hallStyle);
  }

  @Override
  public int delete(HallStyle hallStyle) {
    return hallStyleDAO.delete(hallStyle);
  }

  @Override
  public List<HallStyle> getAll() {
    return hallStyleDAO.getAll();
  }
}
