package service.impl;

import dao.WorkerDAO;
import dao.databace.Database;
import dao.impl.JDBCCRADDao;
import dao.impl.JDBCWorkerDAO;
import entity.Author;
import entity.Worker;
import service.WorkerService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WorkerServiceImpl implements WorkerService {

  private WorkerDAO workerDAO;

  public WorkerServiceImpl() {
    workerDAO = JDBCWorkerDAO.getInstance(Database.getConnection());
  }

  @Override
  public int save(Worker worker) {
    return workerDAO.save(worker);
  }

  @Override
  public int update(Worker worker) {
    return workerDAO.update(worker);
  }

  @Override
  public int delete(Worker worker) {
    return workerDAO.delete(worker);
  }

  @Override
  public Optional<Worker> getOneById(Long id) {
    return workerDAO.getOneById(id);
  }

  @Override
  public List<Worker> getAll() {
    return workerDAO.getAll();
  }

  @Override
  public List<Worker> getAllByPosition(String position) {
    return workerDAO.getWorkersByPosition(position);
  }

  @Override
  public List<Worker> getFreeGuidesForPeriod(LocalDateTime startTime, LocalDateTime endTime) {
    return workerDAO.getFreeGuidesForPeriod(startTime,endTime);
  }

  @Override
  public Map<String, Integer> getStatisticByExcursions() {
    return workerDAO.getStatisticByExcursions();
  }

  @Override
  public Map<String, LocalDateTime> getStatisticAboutWorkedHours() {
    return workerDAO.getStatisticAboutWorkedHours();
  }

}
