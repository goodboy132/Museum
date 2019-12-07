package com.soft.museum.controller.exhibit;
import com.soft.museum.service.AuthorService;
import com.soft.museum.service.ExhibitService;
import com.soft.museum.service.HallService;
import com.soft.museum.service.ServiceFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
