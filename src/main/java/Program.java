import entity.Excursion;
import entity.Worker;
import service.ServiceFactory;

import java.time.LocalDateTime;
import java.util.Date;

public class Program {
  public static void main(String[] args) {
    System.out.println(ServiceFactory.getInstance().getExhibitService().getStatisticByHall());
  }
}
