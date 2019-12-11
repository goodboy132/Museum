package com.soft.museum.controller.statistic;

import com.soft.museum.exception.NotFoundException;
import com.soft.museum.service.ExhibitService;
import com.soft.museum.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;
import java.util.Map;

@WebServlet("/statistic")
public class ExhibitsStatisticServlet extends HttpServlet {
  private ExhibitService exhibitService;

  @Override
  public void init() {
    exhibitService = ServiceFactory.getInstance().getExhibitService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      Map<String, Integer> statisticByMaterial = exhibitService.getStatisticByMaterial();
      Map<String, Integer> statisticByTechnique = exhibitService.getStatisticByTechnique();
      Map<String, Integer> statisticByAuthor = exhibitService.getStatisticByAuthor();
      Map<String, Integer> statisticByHall = exhibitService.getStatisticByHall();

      req.setAttribute("statisticByMaterial", statisticByMaterial);
      req.setAttribute("statisticByTechnique", statisticByTechnique);
      req.setAttribute("statisticByAuthor", statisticByAuthor);
      req.setAttribute("statisticByHall", statisticByHall);
    } catch (NotFoundException e) {
      e.printStackTrace();
    }
    req.getRequestDispatcher("excursionStatistic.jsp").include(req, resp);
  }
}
