package com.soft.museum.controller.excursion;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.entity.Excursion;
import com.soft.museum.entity.TimeTable;
import com.soft.museum.entity.Worker;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
      List<Excursion> excursions = filterExcursions(req);
      req.setAttribute("excursions", excursions);
    } catch (NotFoundException e) {
      resp.sendRedirect(req.getContextPath() + "error?massage=" + e.getMessage());
    } catch (ParseException e) {
      resp.sendRedirect(req.getContextPath() + "error?massage=" + ErrorMessage.INCORRECT_DATE);
    }
    req.getRequestDispatcher("excursions.jsp").include(req, resp);
  }


  private List<Excursion> filterExcursions(HttpServletRequest req) throws NotFoundException, ParseException {
    List<Excursion> excursions;
    if (req.getParameter("from") != null && req.getParameter("to") != null) {
      LocalDateTime from = LocalDateTime.ofInstant(new SimpleDateFormat("yyyy-MM-dd")
              .parse(req.getParameter("from")).toInstant(), ZoneId.systemDefault());
      LocalDateTime to = LocalDateTime.ofInstant(new SimpleDateFormat("yyyy-MM-dd")
              .parse(req.getParameter("to")).toInstant(), ZoneId.systemDefault());
      excursions = excursionService.getAvailableExcursionsForPeriod(from, to);
    } else {
      excursions = excursionService.getAll();
    }
    return excursions;
  }
}
