package service.impl;

import service.AuthorService;
import service.ServiceFactory;

public class ServiceFactoryImpl extends ServiceFactory {
  private AuthorService authorService;


  public AuthorService getAuthorService(){
    if (authorService == null){
      authorService = new AuthorServiceImpl();
    }
    return authorService;
  }

}
