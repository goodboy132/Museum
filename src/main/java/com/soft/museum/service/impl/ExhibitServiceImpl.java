package com.soft.museum.service.impl;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.dao.ExhibitDAO;
import com.soft.museum.dao.databace.Database;
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
      if (exhibit.isPresent()){
        return exhibit.get();
      }
      else {
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
      return exhibitDAO.getAll();
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<Exhibit> getAllByAuthor(Long authorId) throws NotFoundException {
    try {
      return exhibitDAO.getAllByAuthor(authorId);
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<Exhibit> getAllByWorker(Long workerId) throws NotFoundException {
    try {
      return exhibitDAO.getAllByWorker(workerId);
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<Exhibit> getAllByHall(Long hallId) throws NotFoundException {
    try {
      return exhibitDAO.getAllByHole(hallId);
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public Map<String, Integer> getStatisticByMaterial() throws NotFoundException {
    try {
      return exhibitDAO.getStatisticByMaterial();
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public Map<String, Integer> getStatisticByTechnique() throws NotFoundException {
    try {
      return exhibitDAO.getStatisticByTechnique();
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public Map<String,Integer> getStatisticByAuthor() throws NotFoundException {
    try {
      return exhibitDAO.getStatisticByAuthor();
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public Map<String,Integer> getStatisticByHall() throws NotFoundException {
    try {
      return exhibitDAO.getStatisticByHall();
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }
}
