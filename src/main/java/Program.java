import service.ServiceFactory;
public class Program {
  public static void main(String[] args) {
    System.out.println(ServiceFactory.getInstance().getWorkerService().getAllByPosition("GUIDE"));
  }
}
