package service;

import service.impl.ServiceFactoryImpl;

public abstract class ServiceFactory {
  private volatile static ServiceFactory serviceFactory;
  public abstract AuthorService getAuthorService();

  public static ServiceFactory getInstance(){
    if (serviceFactory == null){
      serviceFactory = new ServiceFactoryImpl();
    }
    return serviceFactory;
  }
}
