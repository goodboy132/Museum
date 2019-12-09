package com.soft.museum.controller.exhibit;

import com.soft.museum.entity.Exhibit;
import com.soft.museum.entity.dto.AuthorDto;
import com.soft.museum.entity.dto.ExhibitDto;
import com.soft.museum.exception.NotFoundException;
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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/exhibits")
public class ExhibitsServlet extends HttpServlet {
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
    try {
      List<AuthorDto> authors = authorService.getAll().stream().map(author ->
              new AuthorDto(author.getFirstName(),author.getLastName())).collect(Collectors.toList());
      List<ExhibitDto> exhibits = exhibitService.getAll().stream().map(exhibit -> new ExhibitDto
              (exhibit.getName(), exhibit.getDescription(),
                      new AuthorDto(exhibit.getAuthor().getFirstName(), exhibit.getAuthor().getLastName())))
              .collect(Collectors.toList());
      req.setAttribute("authors",authors);
      req.setAttribute("exhibits", exhibits);
    } catch (NotFoundException e) {
      e.printStackTrace();
    }
    req.getRequestDispatcher("exhibits.jsp").forward(req, resp);
  }
}
