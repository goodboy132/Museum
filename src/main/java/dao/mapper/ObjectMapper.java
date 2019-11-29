package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ObjectMapper<T> {
  public T extractFromResultSet(ResultSet resultSet) throws SQLException;
}
