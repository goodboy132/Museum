import entity.Author;
import service.ServiceFactory;

import java.time.LocalDateTime;

public class Program {
  public static void main(String[] args) {
    Author author = new Author();
    author.setId(7L);

//    ServiceFactory.getInstance().getAuthorService().delete(author);

    System.out.println(ServiceFactory.getInstance().getAuthorService().getAll().toString());
//
//    System.out.println(ServiceFactory.getInstance().getAuthorService().getById(1L).toString());

  }
}
