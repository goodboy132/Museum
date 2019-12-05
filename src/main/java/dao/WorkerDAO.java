package dao;

import entity.Worker;

import java.util.List;

public interface WorkerDAO extends GenericDAO<Worker> {
  List<Worker> getWorkersByPosition(String positionName);
}
