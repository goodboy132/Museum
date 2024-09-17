package com.soft.museum.controller.exhibit;

import com.soft.museum.constant.ErrorMessage;
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
      List<ExhibitDto> exhibitsDto = getExhibitsDto(req);
      List<Hall> halls = hallService.getAll();
      List<AuthorDto> authors = authorService.getAll().stream().map(author ->
              AuthorDto.builder().authorName(author.getFirstName()).authorSurname(author.getLastName()).
                      id(author.getId()).build()).collect(Collectors.toList());
      List<WorkerDto> guides = workerService.getAll().stream().map
              (worker -> WorkerDto.builder().id(worker.getId()).firstName(worker.getFirstName()).
                      lastName(worker.getLastName()).build()).collect(Collectors.toList());
      req.setAttribute("authors", authors);
      req.setAttribute("halls", halls);
      req.setAttribute("guides", guides);
      req.setAttribute("exhibits", exhibitsDto);
    } catch (NotFoundException e) {
      resp.sendRedirect(req.getContextPath() + "error?massage=" + e.getMessage());
    }
    req.getRequestDispatcher("exhibits.jsp").include(req, resp);
  }


  private List<ExhibitDto> getExhibitsDto(HttpServletRequest req) throws NotFoundException {
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
    List<ExhibitDto> exhibitsDto = exhibits.stream().map(exhibit -> ExhibitDto.builder().id(exhibit.getId()).
            exhibitName(exhibit.getName()).description(exhibit.getDescription()).
            authorDto(AuthorDto.builder().authorName(exhibit.getAuthor().getFirstName()).id(exhibit.getAuthor().getId()).
                    authorSurname(exhibit.getAuthor().getLastName()).build()).build()).collect(Collectors.toList());
    return exhibitsDto;
  }

}
