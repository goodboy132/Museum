package dao.impl;

import dao.HallDAO;
import dao.mapper.HallMapper;
import entity.Hall;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class JDBCHallDAO implements HallDAO {
  private static JDBCHallDAO instance;
  private final Connection connection;

  private JDBCHallDAO(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCHallDAO getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCHallDAO(connection);
    }
    return instance;
  }

  @Override
  public Integer save(Hall element) {
    String saveHallQuery = "INSERT INTO hall(hall_name, hall_style_id) VALUES(?,?)";
    return JDBCCRADDao.save(connection, saveHallQuery, element.getName(), element.getHallStyle().getId());
  }

  @Override
  public Integer update(Hall element) {
    String updateHallQuery = "UPDATE hall SET hall_name = ?, hall_style_id = ? WHERE id = ?";
    return JDBCCRADDao.update(connection, updateHallQuery, element.getName(), element.getHallStyle().getId(), element.getId());
  }

  @Override
  public Integer delete(Hall element) {
    String deleteHallQuery = "DELETE FROM hall WHERE id = ?";
    return JDBCCRADDao.update(connection, deleteHallQuery, element.getId());
  }

  @Override
  public Optional<Hall> getOneById(Long elementId) {
    String getOneHallByIdQuery = "SELECT * FROM hall\n" +
            "JOIN hall_style \n" +
            "on hall.hall_style_id = hall_style.id\n" +
            "WHERE hall.id = ?;";
    return JDBCCRADDao.getOneById(connection, getOneHallByIdQuery, elementId, new  HallMapper());
  }

  @Override
  public List<Hall> getAll() {
    String getAllHallsQuery = "SELECT * FROM hall\n" +
            "JOIN hall_style \n" +
            "on hall.hall_style_id = hall_style.id;";
    return JDBCCRADDao.getAll(connection, getAllHallsQuery, new HallMapper());
  }
}
