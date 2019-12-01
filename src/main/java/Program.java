import entity.Author;
import service.ServiceFactory;

import java.time.LocalDateTime;

public class Program {
  public static void main(String[] args) {
    Author author = new Author();
    author.setFirstName("Name");
    author.setLastName("LastName");
    author.setBornDate(LocalDateTime.now());
    ServiceFactory.getInstance().getAuthorService().save(author);
    long a = 4;
    ServiceFactory.getInstance().getAuthorService().getById(a);
  }
}
