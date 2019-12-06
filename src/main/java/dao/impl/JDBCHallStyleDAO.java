package dao.impl;

import dao.HallStyleDAO;
import dao.mapper.HallStyleMapper;
import entity.HallStyle;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class JDBCHallStyleDAO implements HallStyleDAO {
  private static JDBCHallStyleDAO instance;
  private final Connection connection;

  private JDBCHallStyleDAO(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCHallStyleDAO getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCHallStyleDAO(connection);
    }
    return instance;
  }

  @Override
  public Integer save(HallStyle element) {
    String saveHallStyleQuery = "INSERT INTO hall_style(hall_style_name) VALUES(?)";
    return JDBCCRADDao.save(connection, saveHallStyleQuery, element.getName());
  }

  @Override
  public Integer update(HallStyle element) {
    String updateHallStyleQuery = "UPDATE hall_style set hall_style_name = ? WHERE id = ?";
    return JDBCCRADDao.update(connection, updateHallStyleQuery, element.getName(), element.getId());
  }

  @Override
  public Integer delete(HallStyle element) {
    String deleteHallStyleQuery = "DELETE FROM hall_style WHERE id = ?";
    return JDBCCRADDao.update(connection, deleteHallStyleQuery, element.getId());
  }

  @Override
  public Optional<HallStyle> getOneById(Long elementId) {
    String getHallStyleByIdQuery = "SELECT * FROM hall_style WHERE id = ?";
    return JDBCCRADDao.getOne(connection, getHallStyleByIdQuery, new HallStyleMapper(), elementId);
  }

  @Override
  public List<HallStyle> getAll() {
    String getAllHallStylesQuery = "SELECT * FROM hall_style";
    return JDBCCRADDao.getAll(connection, getAllHallStylesQuery, new HallStyleMapper());
  }
}
