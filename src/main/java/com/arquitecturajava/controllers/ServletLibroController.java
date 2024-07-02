package com.arquitecturajava.controllers;

import java.io.IOException;
import com.arquitecturajava.controllers.commands.BorrarLibroCommand;
import com.arquitecturajava.controllers.commands.Command;
import com.arquitecturajava.controllers.commands.FiltroLibroCategoriaCommand;
import com.arquitecturajava.controllers.commands.FormularioNuevoLibroCommand;
import com.arquitecturajava.controllers.commands.InsertarLibroCommand;
import com.arquitecturajava.controllers.commands.ListaLibrosCommand;
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
    Command comando = null;

    try {
      if (req.getParameter("accion") == null) {
        comando = new ListaLibrosCommand();

      } else if (req.getParameter("accion").equals("filtrocategorialibro")) {
        comando = new FiltroLibroCategoriaCommand();
      } else if (req.getParameter("accion").equals("formularionuevolibro")) {
        comando = new FormularioNuevoLibroCommand();

      } else if (req.getParameter("accion").equals("insertarlibro")) {
        comando = new InsertarLibroCommand();
      }

      else if (req.getParameter("accion").equals("borrarlibro")) {
        comando = new BorrarLibroCommand();
      }
      comando.execute(req, resp);

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
