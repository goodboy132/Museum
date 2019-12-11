package com.soft.museum.controller.excursion;

import com.soft.museum.entity.Excursion;
import com.soft.museum.entity.TimeTable;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.service.ExcursionService;
import com.soft.museum.service.ServiceFactory;
import com.soft.museum.service.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/excursions")
public class ExcursionsServlet extends HttpServlet {
  private ExcursionService excursionService;

  @Override
  public void init() {
    excursionService = ServiceFactory.getInstance().getExcursionService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      List<Excursion> excursions = excursionService.getAll();
      System.out.println(excursions);
      req.setAttribute("excursions", excursions);
    } catch (NotFoundException e) {
      resp.sendError(1,e.getLocalizedMessage());
    }
    req.getRequestDispatcher("excursions.jsp").include(req, resp);
  }
}
