package com.soft.museum.service.impl;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.dao.ExhibitDAO;
import com.soft.museum.dao.databace.Database;
import com.soft.museum.dao.impl.JDBCExhibitDAO;
import com.soft.museum.entity.Exhibit;
import com.soft.museum.exception.*;
import com.soft.museum.service.ExhibitService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExhibitServiceImpl implements ExhibitService {
  private ExhibitDAO exhibitDAO;

  ExhibitServiceImpl() {
    exhibitDAO = JDBCExhibitDAO.getInstance(Database.getConnection());
  }


  @Override
  public int save(Exhibit exhibit) throws NotSavedException {
    try {
      return exhibitDAO.save(exhibit);
    } catch (SQLException e) {
      throw new NotSavedException(e.getMessage());
    }
  }

  @Override
  public int update(Exhibit exhibit) throws NotUpdatedException {
    try {
      return exhibitDAO.update(exhibit);
    } catch (SQLException e) {
      throw new NotUpdatedException(e.getMessage());
    }
  }

  @Override
  public int delete(Exhibit exhibit) throws NotDeletedException {
    try {
      return exhibitDAO.delete(exhibit);
    } catch (SQLException e) {
      throw new NotDeletedException(e.getMessage());
    }
  }

  @Override
  public Exhibit getById(Long id) throws NotFoundException {
    try {
      Optional<Exhibit> exhibit = exhibitDAO.getOneById(id);
      if (exhibit.isPresent()) {
        return exhibit.get();
      } else {
        throw new NotFoundException(ErrorMessage.EXHIBIT_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public List<Exhibit> getAll() throws NotFoundException {
    try {
      List<Exhibit> all = exhibitDAO.getAll();
      if (!all.isEmpty()){
        return all;
      }
      else {
        throw new NotFoundException(ErrorMessage.EXHIBITS_NOT_FOUND);
      }
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<Exhibit> getAllByAuthor(Long authorId) throws NotFoundException {
    try {
      List<Exhibit> allByAuthor = exhibitDAO.getAllByAuthor(authorId);
      if (!allByAuthor.isEmpty()) {
        return allByAuthor;
      } else {
        throw new NotFoundException(ErrorMessage.EXHIBITS_WITH_AUTHOR_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public List<Exhibit> getAllByWorker(Long workerId) throws NotFoundException {
    try {
      List<Exhibit> allByWorker = exhibitDAO.getAllByWorker(workerId);
      if (!allByWorker.isEmpty()) {
        return allByWorker;
      } else {
        throw new NotFoundException(ErrorMessage.EXHIBITS_BY_WORKER_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public List<Exhibit> getAllByHall(Long hallId) throws NotFoundException {
    try {
      List<Exhibit> allByHole = exhibitDAO.getAllByHole(hallId);
      if (!allByHole.isEmpty()) {
        return allByHole;
      } else {
        throw new NotFoundException(ErrorMessage.EXHIBITS_IN_HALL_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public Map<String, Integer> getStatisticByMaterial() throws NotFoundException {
    try {
      Map<String, Integer> statisticByMaterial = exhibitDAO.getStatisticByMaterial();
      if (!statisticByMaterial.isEmpty()) {
        return statisticByMaterial;
      } else {
        throw new NotFoundException(ErrorMessage.NO_STATISTIC_ABOUT_EXHIBIT_MATERIAL);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public Map<String, Integer> getStatisticByTechnique() throws NotFoundException {
    try {
      Map<String, Integer> statisticByTechnique = exhibitDAO.getStatisticByTechnique();
      if (!statisticByTechnique.isEmpty()) {
        return statisticByTechnique;
      } else {
        throw new NotFoundException(ErrorMessage.NO_STATISTIC_ABOUT_EXHIBIT_TECHNIQUE);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public Map<String, Integer> getStatisticByAuthor() throws NotFoundException {
    try {
      Map<String, Integer> statisticByAuthor = exhibitDAO.getStatisticByAuthor();
      if (!statisticByAuthor.isEmpty()) {
        return statisticByAuthor;
      } else {
        throw new NotFoundException(ErrorMessage.NO_STATISTIC_ABOUT_EXHIBIT_AUTHOR);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public Map<String, Integer> getStatisticByHall() throws NotFoundException {
    try {
      Map<String, Integer> statisticByHall = exhibitDAO.getStatisticByHall();
      if (!statisticByHall.isEmpty()) {
        return statisticByHall;
      } else {
        throw new NotFoundException(ErrorMessage.NO_STATISTIC_ABOUT_EXHIBIT_HALL);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }
}
