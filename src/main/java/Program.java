import entity.*;
import service.ServiceFactory;

import javax.xml.ws.Service;
import java.sql.Time;
import java.time.LocalDateTime;

public class Program {
  public static void main(String[] args) {


//    System.out.println(ServiceFactory.getInstance().getWorkerService().getOneById(2L).toString());
    System.out.println(ServiceFactory.getInstance().getWorkerService().getAll().toString());
//    System.out.println("All:");

  }
}
