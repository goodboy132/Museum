package com.soft.museum.controller.statistic;

import com.soft.museum.constant.DateParser;
import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.entity.Excursion;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.service.ExcursionService;
import com.soft.museum.service.ExhibitService;
import com.soft.museum.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@WebServlet("/statisticForExcursion")
public class ExcursionStatisticServlet extends HttpServlet {
  private ExcursionService excursionService;

  @Override
  public void init() {
    excursionService = ServiceFactory.getInstance().getExcursionService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      List<LocalDateTime> parsed = DateParser.parse(req.getParameter("from"), req.getParameter("to"));
      Integer count = excursionService.getCountOfExcursionsForPeriod(parsed.get(0), parsed.get(1));
      req.setAttribute("count", count);
      req.getRequestDispatcher("excursionStatistic.jsp").include(req, resp);
    } catch (NotFoundException e) {
      resp.sendRedirect(req.getContextPath() + "error?massage=" + e.getMessage());
    } catch (ParseException e) {
      resp.sendRedirect(req.getContextPath() + "error?massage=" + ErrorMessage.INCORRECT_DATE);
    }
  }
}
