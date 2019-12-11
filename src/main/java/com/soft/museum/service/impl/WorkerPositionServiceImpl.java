package com.soft.museum.service.impl;
import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.dao.WorkerPositionDAO;
import com.soft.museum.dao.database.Database;
import com.soft.museum.dao.impl.JDBCCRUDDao;
import com.soft.museum.dao.impl.JDBCWorkerPositionDao;
import com.soft.museum.entity.Worker;
import com.soft.museum.entity.WorkerPosition;
import com.soft.museum.exception.*;
import com.soft.museum.service.WorkerPositionService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class WorkerPositionServiceImpl implements WorkerPositionService {
  private WorkerPositionDAO workerPositionDAO;
  public WorkerPositionServiceImpl() {
    workerPositionDAO = JDBCWorkerPositionDao.getInstance(Database.getConnection());
  }

  @Override
  public int save(WorkerPosition workerPosition) throws NotSavedException {
    return 0;
  }

  @Override
  public int update(WorkerPosition workerPosition) throws NotUpdatedException {
    return 0;
  }

  @Override
  public int delete(WorkerPosition workerPosition) throws NotDeletedException {
    return 0;
  }

  @Override
  public Optional<WorkerPosition> getOneById(Long id) throws NotFoundException {
    return Optional.empty();
  }

  @Override
  public List<WorkerPosition> getAll() throws NotFoundException {
    try {
      List<WorkerPosition> positions = workerPositionDAO.getAll();
      if (!positions.isEmpty()) {
        return positions;
      } else {
        throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }
}
