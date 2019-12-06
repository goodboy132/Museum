package dao.mapper;

import org.omg.CORBA.Object;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class StatisticMapper implements ObjectMapper<Map<String,Integer>> {
  @Override
  public Map<String, Integer> extractFromResultSet(ResultSet resultSet) throws SQLException {
    Map<String,Integer> statistic = new HashMap<>();
    while (resultSet.next()){
      statistic.put(resultSet.getString("material_name"),resultSet.getInt("count_of_material"));
    }
    return statistic;
  }
}
