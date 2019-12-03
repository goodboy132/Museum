import entity.*;
import service.ServiceFactory;

import javax.xml.ws.Service;
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
    HallStyle hallStyle = new HallStyle();
    hallStyle.setId(4L);
    hallStyle.setName("detective");

    Hall hall = new Hall();
    hall.setName("Pasha");
    hall.setHallStyle(hallStyle);


    ServiceFactory.getInstance().getHallService().save(hall);

//    System.out.println(ServiceFactory.getInstance().getHallService().getAll().toString());
//    System.out.println(ServiceFactory.getInstance().getHallService().getById(2L).toString());
//    WorkerPosition workerPosition = new WorkerPosition();
//    workerPosition.setId(2L);
//    workerPosition.setName("*****");
//
//    ServiceFactory.getInstance().getWorkerPositionService().update(workerPosition);
  }
}
