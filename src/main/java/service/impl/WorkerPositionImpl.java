package service.impl;

import dao.WorkerPositionDAO;
import dao.databace.Database;
import dao.impl.JDBCWorkerPositionDAO;
import entity.WorkerPosition;
import service.WorkerPositionService;

import java.util.List;
import java.util.Optional;

public class WorkerPositionImpl implements WorkerPositionService {

  private WorkerPositionDAO workerPositionDAO;

  public WorkerPositionImpl() {
    workerPositionDAO = JDBCWorkerPositionDAO.getInstance(Database.getConnection());
  }

  @Override
  public int save(WorkerPosition workerPosition) {
    return workerPositionDAO.save(workerPosition);
  }

  @Override
  public int update(WorkerPosition workerPosition) {
    return workerPositionDAO.update(workerPosition);
  }

  @Override
  public int delete(WorkerPosition workerPosition) {
    return workerPositionDAO.delete(workerPosition);
  }

  @Override
  public Optional<WorkerPosition> getOneById(Long id) {
    return workerPositionDAO.getOneById(id);
  }

  @Override
  public List<WorkerPosition> getAll() {
    return workerPositionDAO.getAll();
  }
}
