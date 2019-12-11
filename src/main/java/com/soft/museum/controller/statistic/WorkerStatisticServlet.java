package com.soft.museum.controller.statistic;

import com.soft.museum.exception.NotFoundException;
import com.soft.museum.service.ServiceFactory;
import com.soft.museum.service.WorkerService;
import lombok.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/statisticForEmployee")
public class WorkerStatisticServlet extends HttpServlet {
  private WorkerService workerService;

  @Override
  public void init(){
    workerService = ServiceFactory.getInstance().getWorkerService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      Map<String, Integer> statisticByExcursions = workerService.getStatisticByExcursions();
      req.setAttribute("statisticByExcursion", statisticByExcursions);
    } catch (NotFoundException e) {
      e.printStackTrace();
    }
    req.getRequestDispatcher("excursionStatistic.jsp").include(req, resp);
  }
}
