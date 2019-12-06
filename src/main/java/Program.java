import entity.Excursion;
import entity.Exhibit;
import entity.HallStyle;
import entity.Worker;
import service.ServiceFactory;

import java.time.LocalDateTime;
import java.util.Date;

public class Program {
  public static void main(String[] args) {
    Exhibit exhibit=new Exhibit();
    HallStyle hallStyle = new HallStyle();

//    LocalDateTime localDateTime = LocalDateTime.of(2019, 1, 1, 12, 12);
//    LocalDateTime localDateTime2 = LocalDateTime.of(2020, 12, 12, 12, 12);
//
//
//    System.out.println(ServiceFactory.getInstance().getExcursionService().getCountOfExcursionsForPeriod(localDateTime, localDateTime2));
//    System.out.println(ServiceFactory.getInstance().getExcursionService().getAvailableExcursionsForPeriod(localDateTime, localDateTime2));
    System.out.println(ServiceFactory.getInstance().getWorkerService().getStatisticByExcursions());
  }

}
