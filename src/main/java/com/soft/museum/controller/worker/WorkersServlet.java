package com.soft.museum.controller.worker;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.entity.Worker;
import com.soft.museum.entity.WorkerPosition;
import com.soft.museum.entity.dto.WorkerDto;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.service.ServiceFactory;
import com.soft.museum.service.WorkerPositionService;
import com.soft.museum.service.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/employees")
public class WorkersServlet extends HttpServlet {
  private WorkerService workerService;
  private WorkerPositionService workerPositionService;

  @Override
  public void init() throws ServletException {
    this.workerService = ServiceFactory.getInstance().getWorkerService();
    this.workerPositionService = ServiceFactory.getInstance().getWorkerPositionService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      List<Worker> filteredWorkers = filteredWorkers(req);
      List<WorkerPosition> positions = workerPositionService.getAll();
      req.setAttribute("employees", filteredWorkers);
      req.setAttribute("positions", positions);
      req.getRequestDispatcher("employees.jsp").include(req, resp);
    } catch (NotFoundException e) {
      resp.sendRedirect(req.getContextPath() + "error?massage="+e.getMessage());
    }
    catch (ParseException e){
      resp.sendRedirect(req.getContextPath() + "error?massage="+ ErrorMessage.INCORRECT_DATE);
    }
  }



  private List<Worker> filteredWorkers(HttpServletRequest req) throws NotFoundException, ParseException {
    List<Worker> workers;
    if (req.getParameter("filter") != null) {
     return workerService.getAllByPosition(req.getParameter("filter"));
    }
    if (req.getParameter("from") != null && req.getParameter("to") != null) {
      Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("from"));
      Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("to"));
      LocalDateTime from = LocalDateTime.ofInstant(date1.toInstant(), ZoneId.systemDefault());
      LocalDateTime to = LocalDateTime.ofInstant(date2.toInstant(), ZoneId.systemDefault());
      return workerService.getFreeGuidesForPeriod(from, to);
    } else {
      workers = workerService.getAll();
    }
    return workers;
  }
}
