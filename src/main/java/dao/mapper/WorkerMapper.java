package dao.mapper;

import entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerMapper implements ObjectMapper<Worker> {
  @Override
  public Worker extractFromResultSet(ResultSet resultSet) throws SQLException {
    Worker worker = new Worker();

    worker.setId(resultSet.getLong("worker.id"));
    worker.setFirstName(resultSet.getString("worker.name"));
    worker.setLastName(resultSet.getString("worker.surname"));
    worker.setLogin(resultSet.getString("worker.username"));
    worker.setPassword(resultSet.getString("worker.password"));

    return worker;
  }
}
