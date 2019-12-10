package com.soft.museum.controller.worker;

import com.soft.museum.entity.Worker;
import com.soft.museum.entity.dto.WorkerDto;
import com.soft.museum.exception.NotFoundException;
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
import java.util.stream.Stream;

@WebServlet("/employees")
public class WorkersServlet extends HttpServlet {
  private WorkerService workerService;

  @Override
  public void init() throws ServletException {
    this.workerService = ServiceFactory.getInstance().getWorkerService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      List<WorkerDto> workers = workerService.getAll().stream().map(worker ->
              new WorkerDto(worker.getId(), worker.getFirstName(),
              worker.getLastName())).collect(Collectors.toList());
      req.setAttribute("employees",workers);
      req.getRequestDispatcher("employees.jsp");
    } catch (NotFoundException e) {
      e.printStackTrace();
    }
  }
}
