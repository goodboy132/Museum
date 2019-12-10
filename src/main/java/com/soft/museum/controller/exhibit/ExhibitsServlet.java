package com.soft.museum.controller.exhibit;

import com.soft.museum.entity.Exhibit;
import com.soft.museum.entity.Hall;
import com.soft.museum.entity.Worker;
import com.soft.museum.entity.dto.AuthorDto;
import com.soft.museum.entity.dto.ExhibitDto;
import com.soft.museum.entity.dto.WorkerDto;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/exhibits")
public class ExhibitsServlet extends HttpServlet {
  private ExhibitService exhibitService;
  private AuthorService authorService;
  private HallService hallService;
  private WorkerService workerService;

  @Override
  public void init() {
    exhibitService = ServiceFactory.getInstance().getExhibitService();
    authorService = ServiceFactory.getInstance().getAuthorService();
    hallService = ServiceFactory.getInstance().getHallService();
    workerService = ServiceFactory.getInstance().getWorkerService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      List<Exhibit> exhibits;
      if (req.getParameter("hall") != null) {
        exhibits = exhibitService.getAllByHall(Long.valueOf(req.getParameter("hall")));
      } else if (req.getParameter(("author")) != null) {
        exhibits = exhibitService.getAllByAuthor(Long.valueOf(req.getParameter("author")));
      } else if (req.getParameter(("guide")) != null) {
        exhibits = exhibitService.getAllByWorker(Long.valueOf(req.getParameter("guide")));
      } else {
        exhibits = exhibitService.getAll();
      }
      List<ExhibitDto> exhibitsDto = exhibits.stream().map(exhibit -> new ExhibitDto
              (exhibit.getId(), exhibit.getName(), exhibit.getDescription(),
                      new AuthorDto(exhibit.getId(), exhibit.getAuthor().getFirstName(),
                              exhibit.getAuthor().getLastName()))).collect(Collectors.toList());
      List<AuthorDto> authors = authorService.getAll().stream().map(author ->
              new AuthorDto(author.getId(), author.getFirstName(), author.getLastName())).collect(Collectors.toList());
      List<Hall> halls = hallService.getAll();
      List<WorkerDto> guides = workerService.getAll().stream().map
              (worker -> new WorkerDto(worker.getId(), worker.getFirstName(), worker.getLastName())).collect(Collectors.toList());
      req.setAttribute("authors", authors);
      req.setAttribute("halls", halls);
      req.setAttribute("guides", guides);
      req.setAttribute("exhibits", exhibitsDto);
    } catch (NotFoundException e) {
      resp.sendRedirect("http://localhost:8080/error");
    }
    req.getRequestDispatcher("exhibits.jsp").include(req, resp);
  }
}
