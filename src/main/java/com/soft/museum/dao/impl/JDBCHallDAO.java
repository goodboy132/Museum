package com.soft.museum.dao.impl;

import com.soft.museum.dao.HallDAO;
import com.soft.museum.dao.mapper.HallMapper;
import com.soft.museum.entity.Hall;

import java.sql.Connection;
import java.sql.SQLException;
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
  public Integer save(Hall element) throws SQLException {
    String saveHallQuery = "INSERT INTO hall(hall_name, hall_style_id) VALUES(?,?)";
    return JDBCCRADDao.save(connection, saveHallQuery, element.getName(), element.getHallStyle().getId());
  }

  @Override
  public Integer update(Hall element) throws SQLException {
    String updateHallQuery = "UPDATE hall SET hall_name = ?, hall_style_id = ? WHERE id = ?";
    return JDBCCRADDao.update(connection, updateHallQuery, element.getName(), element.getHallStyle().getId(),
            element.getId());
  }

  @Override
  public Integer delete(Hall element) throws SQLException {
    String deleteHallQuery = "DELETE FROM hall WHERE id = ?";
    return JDBCCRADDao.update(connection, deleteHallQuery, element.getId());
  }

  @Override //show without hall_style
  public Optional<Hall> getOneById(Long elementId) throws SQLException {
    String getOneHallByIdQuery = "select * from hall " +
            "join hall_style " +
            "on hall.hall_style_id = hall_style.id " +
            "where hall.id = ?";
    return JDBCCRADDao.getOne(connection, getOneHallByIdQuery, new  HallMapper(), elementId);
  }

  @Override //show without hall_style
  public List<Hall> getAll() throws SQLException {
    String getAllHallsQuery = "select * from hall " +
            "join hall_style " +
            "on hall.hall_style_id = hall_style.id;";
    return JDBCCRADDao.getAll(connection, getAllHallsQuery, new HallMapper());
  }
}
