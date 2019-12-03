package service.impl;

import entity.Exhibit;
import service.*;

public class ServiceFactoryImpl extends ServiceFactory {
  private AuthorService authorService;
  private ExhibitService exhibitService;
  private HallStyleService hallStyleService;
  private HallService hallService;
  private MaterialService materialService;
  private WorkerPositionService workerPositionService;



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

  @Override
  public HallStyleService getHallStyleService() {
    if (hallStyleService == null) {
      hallStyleService = new HallStyleServiceImpl();
    }
    return hallStyleService;
  }

  @Override
  public HallService getHallService() {
    if (hallService == null) {
      hallService = new HallServiceImpl();
    }
    return hallService;
  }

  @Override
  public MaterialService getMaterialService() {
    if (materialService == null) {
      materialService = new MaterialServiceImpl();
    }
    return materialService;
  }

  @Override
  public WorkerPositionService getWorkerPositionService() {
    if (workerPositionService == null) {
      workerPositionService = new WorkerPositionImpl();
    }
    return workerPositionService;
  }

}
