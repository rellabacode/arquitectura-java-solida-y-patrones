package com.rellabacode.controllers;

import java.io.IOException;
import com.rellabacode.controllers.commands.BorrarLibroCommand;
import com.rellabacode.controllers.commands.Command;
import com.rellabacode.controllers.commands.FiltroLibroCategoriaCommand;
import com.rellabacode.controllers.commands.FormularioNuevoLibroCommand;
import com.rellabacode.controllers.commands.InsertarLibroCommand;
import com.rellabacode.controllers.commands.ListaLibrosCommand;
import com.rellabacode.controllers.commands.Router;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Resp: CONTROL
@WebServlet("/controlador")
public class ServletLibroController extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = -1979102707959943514L;

  public void doExternalGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    try {
      //todo delegado en el router
      Router.getCommand(req.getParameter("accion")).execute(req, resp);

    } catch (Exception e) {
      throw new RuntimeException();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }

}
