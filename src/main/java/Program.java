import entity.Excursion;
import entity.Exhibit;
import entity.HallStyle;
import entity.Worker;
import service.ServiceFactory;

import java.time.LocalDateTime;
import java.util.Date;

public class Program {
  public static void main(String[] args) {
    LocalDateTime t1 = LocalDateTime.of(2000, 1, 1, 1 , 1, 1);
    LocalDateTime t2 = LocalDateTime.of(2030, 1, 1, 1 , 1, 1);

    System.out.println(t1);
    System.out.println(t2);
    System.out.println(ServiceFactory.getInstance().getWorkerService().getStatisticAboutWorkedHours());

  }

}
