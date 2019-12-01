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

  @Override //Don't work
  public Integer save(Hall element) {
    String saveHallQuery = "INSERT INTO hall(hall_name, hall_style) VALUES(??)";
    return JDBCCRADDao.save(connection, saveHallQuery, element.getName(), element.getHallStyle());
  }

  @Override //Don't work
  public Integer update(Hall element) {
    String updateHallQuery = "UPDATE hall SET hall_name = ?, hall_style = ? WHERE id = ?";
    return JDBCCRADDao.update(connection, updateHallQuery, element.getName(), element.getHallStyle(), element.getId());
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
            "on hall.hall_style = hall_style.id\n" +
            "WHERE hall.id = ?;";
    return JDBCCRADDao.getOneById(connection, getOneHallByIdQuery, elementId, new  HallMapper());
  }

  @Override
  public List<Hall> getAll() {
    String getAllHallsQuery = "SELECT * FROM hall\n" +
            "JOIN hall_style \n" +
            "on hall.hall_style = hall_style.id;";
    return JDBCCRADDao.getAll(connection, getAllHallsQuery, new HallMapper());
  }
}
