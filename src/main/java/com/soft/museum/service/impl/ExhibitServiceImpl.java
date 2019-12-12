package com.soft.museum.service.impl;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.dao.ExhibitDAO;
import com.soft.museum.dao.database.Database;
import com.soft.museum.dao.impl.JDBCExhibitDAO;
import com.soft.museum.entity.Exhibit;
import com.soft.museum.exception.*;
import com.soft.museum.service.ExhibitService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExhibitServiceImpl implements ExhibitService {
  private ExhibitDAO exhibitDAO;

  /**
   * Default constructor
   */
  ExhibitServiceImpl() {
    exhibitDAO = JDBCExhibitDAO.getInstance(Database.getConnection());
  }

  /**
   * Method for saving object Exhibit in database
   *
   * @return true if the save was successful
   */
  @Override
  public int save(Exhibit exhibit) throws NotSavedException {
    try {
      Integer save = exhibitDAO.save(exhibit);
      if (save > 0) {
        return save;
      } else {
        throw new NotSavedException(ErrorMessage.EXHIBIT_NOT_SAVED);
      }
    } catch (SQLException e) {
      throw new NotSavedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that updates given object Exhibit
   *
   * @return 1 if the update was successful
   */
  @Override
  public int update(Exhibit exhibit) throws NotUpdatedException {
    try {
      Integer update = exhibitDAO.update(exhibit);
      if (update > 0) {
        return update;
      } else {
        throw new NotUpdatedException(ErrorMessage.EXHIBIT_NOT_UPDATED);
      }
    } catch (SQLException e) {
      throw new NotUpdatedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that deletes given object Exhibit
   *
   * @return 1 if the delete was successful
   */
  @Override
  public int delete(Exhibit exhibit) throws NotDeletedException {
    try {
      Integer deleteExhibit = exhibitDAO.delete(exhibit);
      if (deleteExhibit > 0) {
        return deleteExhibit;
      } else {
        throw new NotDeletedException(ErrorMessage.EXHIBIT_NOT_DELETED);
      }
    } catch (SQLException e) {
      throw new NotDeletedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that returns object Exhibit wrapped in Optional by id
   *
   * @return Object Exhibit wrapped in Optional
   */
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
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that returns all objects of Exhibits
   *
   * @return list of Exhibits
   */
  @Override
  public List<Exhibit> getAll() throws NotFoundException {
    try {
      List<Exhibit> all = exhibitDAO.getAll();
      if (!all.isEmpty()) {
        return all;
      } else {
        throw new NotFoundException(ErrorMessage.EXHIBITS_NOT_FOUND);
      }
    } catch (SQLException e) {
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that returns all objects of Exhibits by author
   *
   * @param authorId Author id
   * @return list of Exhibits by author
   */
  @Override
  public List<Exhibit> getAllByAuthor(Long authorId) throws NotFoundException {
    try {
      List<Exhibit> allByAuthor = exhibitDAO.getAllByAuthor(authorId);
      if (!allByAuthor.isEmpty()) {
        return allByAuthor;
      } else {
        throw new NotFoundException(ErrorMessage.EXHIBITS_WITH_AUTHOR_NOT_FOUND + authorId);
      }
    } catch (SQLException e) {
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that returns all objects of Exhibits by worker
   *
   * @param workerId Worker id
   * @return list of Exhibits by worker
   */
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
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that returns all objects of Exhibits by hall
   *
   * @param hallId Hall id
   * @return list of Exhibits by hall
   */
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
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that returns statistic by exhibit's material
   *
   * @return map where key is name of Exhibit, value is there count
   */
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
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that returns statistic by exhibit's technique
   *
   * @return map where key is name of Exhibit, value is there count
   */
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
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that returns statistic by exhibit's author
   *
   * @return map where key is name of Exhibit, value is there count
   */
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
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that returns statistic by exhibit's hall
   *
   * @return map where key is name of Exhibit, value is there count
   */
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
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }
}
