package service.impl;

import entity.Exhibit;
import service.AuthorService;
import service.ExhibitService;
import service.ServiceFactory;

public class ServiceFactoryImpl extends ServiceFactory {
  private AuthorService authorService;
  private ExhibitService exhibitService;


  public AuthorService getAuthorService(){
    if (authorService == null){
      authorService = new AuthorServiceImpl();
    }
    return authorService;
  }
  public ExhibitService getExhibitService(){
    if (exhibitService == null){
      exhibitService = new ExhibitServiceImpl();
    }
    return exhibitService;
  }

}
