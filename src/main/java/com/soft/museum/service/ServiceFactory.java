package com.soft.museum.service;

import com.soft.museum.service.impl.ServiceFactoryImpl;

public abstract class ServiceFactory {
  private volatile static ServiceFactory serviceFactory;
  public abstract AuthorService getAuthorService();
  public abstract ExhibitService getExhibitService();
  public abstract HallStyleService getHallStyleService();
  public abstract HallService getHallService();
  public abstract MaterialService getMaterialService();
  public abstract WorkerService getWorkerService();
  public abstract  ExcursionService getExcursionService();

  public static ServiceFactory getInstance(){
    if (serviceFactory == null){
      serviceFactory = new ServiceFactoryImpl();
    }
    return serviceFactory;
  }
}
