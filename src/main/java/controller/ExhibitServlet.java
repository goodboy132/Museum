package controller;

import com.sun.net.httpserver.HttpServer;
import entity.Author;
import entity.Exhibit;
import service.AuthorService;
import service.ExhibitService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/")
public class ExhibitServlet extends HttpServlet {
  private ExhibitService exhibitService;
  AuthorService authorService;

  @Override
  public void init() throws ServletException {
    exhibitService = ServiceFactory.getInstance().getExhibitService();
    authorService = ServiceFactory.getInstance().getAuthorService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Author author = new Author();
    author.setBornDate(LocalDateTime.now());
    authorService.save(author);

    List<Exhibit> exhibits = exhibitService.getAll();
    req.setAttribute("exhibits",exhibits);
    req.getRequestDispatcher("exhibits.jsp").include(req,resp);
  }
}
