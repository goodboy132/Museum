package dao.impl;

import dao.WorkerDAO;
import dao.mapper.*;
import entity.*;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.*;

public class JDBCWorkerDAO implements WorkerDAO {
  private static JDBCWorkerDAO instance;
  private final Connection connection;

  public JDBCWorkerDAO(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCWorkerDAO getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCWorkerDAO(connection);
    }
    return instance;
  }

  @Override
  public Integer save(Worker element) {
    String saveWorkerQuery = "insert into worker(name, surname, position_id, username, password) values(?,?,?,?,?)";
    return JDBCCRADDao.save(connection, saveWorkerQuery, element.getFirstName(), element.getLastName(), element.getWorkerPosition().getId(), element.getLogin(), element.getPassword());
  }

  @Override
  public Integer update(Worker element) {
    String updateWorkerQuery = "update worker set name = ?, surname = ?, position_id = ?, username = ?, password = ? where id = ?";
    return JDBCCRADDao.update(connection, updateWorkerQuery, element.getFirstName(), element.getLastName(), element.getWorkerPosition().getId(), element.getLogin(), element.getPassword(), element.getId());
  }

  @Override
  public Integer delete(Worker element) {
    String deleteWorkerQuery = "delete from worker where worker.id = ?";
    return JDBCCRADDao.update(connection, deleteWorkerQuery, element.getId());
  }

  @Override
  public Optional<Worker> getOneById(Long elementId) {
    String getOneWorkerWithHallIdQuery = "select worker.id, worker.name, worker.surname, worker.position_id," +
            " worker.username, worker.password from worker where worker.id = ?";
    Optional<Worker> worker =
            JDBCCRADDao.getOne(connection, getOneWorkerWithHallIdQuery,  new WorkerMapper(), elementId);
    worker.ifPresent(this::setMappedFieldsToWorker);
    return worker;
  }

  @Override
  public List<Worker> getAll() {
    String getAllWorkersQuery = "select * from worker join worker_position on worker.position_id = worker_position.id";
    List<Worker> workers = JDBCCRADDao.getAll(connection, getAllWorkersQuery, new WorkerMapper());
    workers.forEach(this::setMappedFieldsToWorker);
    return workers;
  }

  public List<Worker> getWorkersByPosition(String positionName) {
    String getGuidesQuery = "select * from worker w join worker_position wp on w.position_id =" +
            " wp.id where wp.position_name = ?";
    List<Worker> workers = JDBCCRADDao.getAll(connection, getGuidesQuery, new WorkerMapper(), positionName);
    workers.forEach(this::setMappedFieldsToWorker);
    return workers;
  }

  public List<Worker> getFreeGuidesForPeriod(LocalDateTime startTime, LocalDateTime endTime){
    String getAvailableGuidesQuery = "select * from worker w join worker_position wp on w.position_id " +
            "= wp.id join excursion e on w.id = e.worker_id join time_table tt on   e.id = tt.excursion_id " +
            "where wp.position_name = 'GUIDE' and tt.start_time between ? and ?";
    List<Worker> workers = JDBCCRADDao.getAll(connection,getAvailableGuidesQuery,new WorkerMapper(),startTime,endTime);
    workers.forEach(this::setMappedFieldsToWorker);
    return workers;
  }


  private void setMappedFieldsToWorker(Worker worker) {
   setWorkerExcursions(worker);
   setWorkerPosition(worker);
   setWorkerHalls(worker);
  }


  private void setWorkerHalls(Worker worker){
    String setWorkerHallsQuery = "select * from hall h join worker_hall wh on h.id = wh.hall_id where wh.worker_id = ?";
    List<Hall> halls = JDBCCRADDao.getAll(connection, setWorkerHallsQuery, new HallMapper(), worker.getId());
    worker.setHalls(halls);
  }

  private void setWorkerPosition(Worker worker) {
    String setWorkerPositionQuery = "select * from worker_position join worker w on worker_position.id = " +
            "w.position_id where w.id = ?";
    Optional<WorkerPosition> position = JDBCCRADDao.getOne
            (connection, setWorkerPositionQuery, new WorkerPositionMapper(),  worker.getId());
    worker.setWorkerPosition(position.get());
  }

  private void setWorkerExcursions(Worker worker){
    String setWorkerExcursionsQuery = "select * from excursion e where e.worker_id = ?";
    List<Excursion> excursions = JDBCCRADDao.getAll
            (connection, setWorkerExcursionsQuery, new ExcursionMapper(), worker.getId());
    worker.setExcursions(excursions);
  }

  @Override
  public Map<String, Integer> getStatisticByExcursions() {
    String getCountOfFinishedExcursion = "SELECT museum.worker.*, COUNT(*) as count_rows FROM museum.worker\n" +
            "join museum.excursion\n" +
            "on excursion.worker_id = worker.id\n" +
            "join museum.time_table\n" +
            "on time_table.excursion_id = excursion.id\n" +
            "group by worker.surname";
    return JDBCCRADDao.getOne(connection, getCountOfFinishedExcursion, new StatisticExcursionMapper()).get();
  }

  @Override
  public Map<String, LocalDateTime> getStatisticAboutWorkedHours() {
    String getStatisticAboutWorkedHoursQuery = "select worker.*, SEC_TO_TIME(SUM(TIME_TO_SEC(end_time) - TIME_TO_SEC(start_time))) as duration from worker \n" +
            "join excursion\n" +
            "on excursion.worker_id = worker.id\n" +
            "join time_table\n" +
            "on time_table.excursion_id = excursion.id\n" +
            "group by worker.surname";
    return JDBCCRADDao.getOne(connection, getStatisticAboutWorkedHoursQuery, new WorkedHoursMapper()).get();
  }
}
