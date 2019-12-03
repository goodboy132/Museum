import entity.*;
import service.ServiceFactory;

import javax.xml.ws.Service;
import java.sql.Time;
import java.time.LocalDateTime;

public class Program {
  public static void main(String[] args) {

//    Author author1 = new Author();
//    author1.setFirstName("Andriy");
//    author1.setLastName("Mylyarenko");
//    author1.setBornDate(LocalDateTime.now());
//    author1.setDeathDate(LocalDateTime.now());
//

//
//    Exhibit exhibit= new Exhibit();
//    exhibit.setName("name");
//    exhibit.setReceiptDate(LocalDateTime.now());
//    exhibit.setTechnique("technique");
//    exhibit.setDescription("description");
//    exhibit.setAuthor();
//    exhibit.setHall();
    long milli = 123456789999l;


    java.sql.Time time = new java.sql.Time(milli);

    ExcursionTime excursionTime = new ExcursionTime();
    excursionTime.setId(2L);
    excursionTime.setStartTime(LocalDateTime.now());
    excursionTime.setEndTime(LocalDateTime.now());

    System.out.println(ServiceFactory.getInstance().getExcursionTimeService().delete(excursionTime));

//    System.out.println(ServiceFactory.getInstance().getHallService().getAll().toString());
//    System.out.println(ServiceFactory.getInstance().getHallService().getById(2L).toString());
//    WorkerPosition workerPosition = new WorkerPosition();
//    workerPosition.setId(2L);
//    workerPosition.setName("*****");
//
//    ServiceFactory.getInstance().getWorkerPositionService().update(workerPosition);
  }
}
