package controller.exhibit;
import entity.Author;
import entity.Exhibit;
import entity.Worker;
import service.AuthorService;
import service.ExhibitService;
import service.HallService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/exhibits")
public class ExhibitServlet extends HttpServlet {
  private ExhibitService exhibitService;
  private AuthorService authorService;
  private HallService hallService;

  @Override
  public void init() {
    exhibitService = ServiceFactory.getInstance().getExhibitService();
    authorService = ServiceFactory.getInstance().getAuthorService();
    hallService = ServiceFactory.getInstance().getHallService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    req.setAttribute("authors", authorService.getAll());
//    req.setAttribute("halls", hallService.getAll());
    req.getRequestDispatcher("main.jsp").forward(req,resp);
  }
}
