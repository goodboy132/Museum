import entity.Excursion;
import entity.Worker;
import service.ServiceFactory;

import java.time.LocalDateTime;
import java.util.Date;

public class Program {
  public static void main(String[] args) {
//    Date date = new Date();
    LocalDateTime of = LocalDateTime.of(2010, 12, 22, 12, 22);
    LocalDateTime of1 = LocalDateTime.of(2020, 12, 22, 12, 22);
//    System.out.println(ServiceFactory.getInstance().getWorkerService().getFreeGuidesForPeriod(of,of1));

    System.out.println(ServiceFactory.getInstance().getExcursionService().getAvailableExcursionsForPeriod(of, of1));
  }
}
