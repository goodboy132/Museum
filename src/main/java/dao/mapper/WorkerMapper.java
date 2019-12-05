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
    worker.setId(resultSet.getLong("id"));
    worker.setFirstName(resultSet.getString("name"));
    worker.setLastName(resultSet.getString("surname"));
    worker.setLogin(resultSet.getString("username"));
    worker.setPassword(resultSet.getString("password"));
    return worker;
  }
}
