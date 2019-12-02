package dao.impl;

import dao.ExcursionTimeDAO;
import entity.ExcursionTime;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class JDBCExcursionTimeDAO implements ExcursionTimeDAO {
  private static JDBCExcursionTimeDAO instance;
  private final Connection connection;

  public JDBCExcursionTimeDAO(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCExcursionTimeDAO getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCExcursionTimeDAO(connection);
    }
    return instance;
  }

  @Override
  public Integer save(ExcursionTime element) {
    String saveExcursionTimeQuery = "insert into excursion_time(start_time, end_time) values(??)";
    return JDBCCRADDao.save(connection, saveExcursionTimeQuery, element.getStartTime(), element.getEndTime());
  }

  @Override
  public Integer update(ExcursionTime element) {
    String updateExcursionTimeQuery = "update excursion_time set start_time = ?, end_time = ? where id = ?";
    return JDBCCRADDao.update(connection, updateExcursionTimeQuery, element.getStartTime(), element.getEndTime(), element.getId());
  }

  @Override
  public Integer delete(ExcursionTime element) {
    String deleteExcursionTimeQuery = "delete from excursion_time where id = ?";
    return JDBCCRADDao.update(connection, deleteExcursionTimeQuery, element.getId());
  }

  @Override
  public Optional<ExcursionTime> getOneById(Long elementId) {
    String getOneExcursionTimeQuery = "select * from excursion_time where id = ?";
    return JDBCCRADDao.getOneById(connection, getOneExcursionTimeQuery, elementId, new Exc);
  }

  @Override
  public List<ExcursionTime> getAll() {
    return null;
  }
}
