import entity.Author;
import service.ServiceFactory;

public class Program {
  public static void main(String[] args) {
//    Author author = new Author();
//    author.setFirstName("toha");
//    author.setLastName("vasa");
//    ServiceFactory.getInstance().getAuthorService().save(author);
    long a = 4;
    System.out.println(ServiceFactory.getInstance().getAuthorService().getById(a).get());
  }
}
