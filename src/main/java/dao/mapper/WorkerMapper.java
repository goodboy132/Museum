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
    WorkerPosition workerPosition = new WorkerPosition();
    Hall hall = new Hall();
    HallStyle hallStyle = new HallStyle();
    Excursion excursion = new Excursion();
    List<Hall> halls = new ArrayList<>();
    List<Excursion> excursions = new ArrayList<>();

    worker.setId(resultSet.getLong("worker.id"));
    worker.setFirstName(resultSet.getString("worker.name"));
    worker.setLastName(resultSet.getString("worker.surname"));
    worker.setLogin(resultSet.getString("worker.username"));
    worker.setPassword(resultSet.getString("worker.password"));

    workerPosition.setId(resultSet.getLong("worker_position.id"));
    workerPosition.setName(resultSet.getString("worker_position.position_name"));


    while(resultSet.next()) {
      hall.setId(resultSet.getLong("hall.id"));
      hall.setName(resultSet.getString("hall.hall_name"));

      hallStyle.setId(resultSet.getLong("hall_style.id"));
      hallStyle.setName(resultSet.getString("hall_style.hall_style_name"));

      hall.setHallStyle(hallStyle);

      halls.add(hall);
    }

    while(resultSet.next()) {
      ExcursionTime excursionDate = new ExcursionTime();
      excursion.setId(resultSet.getLong("id"));
      excursion.setTimeTable(resultSet.getString("time_table"));
      excursion.setName(resultSet.getString("excursion_name"));
      excursion.setProgram(resultSet.getString("excursion_program"));
      excursionDate.setId(resultSet.getLong("id"));
      excursionDate.setStartTime(resultSet.getTimestamp("start_time").toLocalDateTime());
      excursionDate.setEndTime(resultSet.getTimestamp("end_time").toLocalDateTime());
      excursion.setExcursionDate(excursionDate);

      excursions.add(excursion);
    }

    worker.setHalls(halls);

    worker.setWorkerPosition(workerPosition);
    worker.setExcursions(excursions);

    return worker;
  }
}
