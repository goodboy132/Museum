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

  /**
   * Default constructor
   */
  public WorkerPositionServiceImpl() {
    workerPositionDAO = JDBCWorkerPositionDao.getInstance(Database.getConnection());
  }

  /**
   * Method, that returns all objects of WorkerPosition
   *
   * @return list of WorkerPositions
   */
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
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }
}
