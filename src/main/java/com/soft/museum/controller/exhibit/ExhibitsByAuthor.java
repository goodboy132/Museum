package com.soft.museum.controller.exhibit;

import com.soft.museum.service.ExhibitService;
import com.soft.museum.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exhibits/byAuthor")
public class ExhibitsByAuthor extends HttpServlet {
  private ExhibitService exhibitService;

  @Override
  public void init() throws ServletException {
    exhibitService = ServiceFactory.getInstance().getExhibitService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  }
}
