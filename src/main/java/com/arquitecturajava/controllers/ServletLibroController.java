package com.arquitecturajava.controllers;

import java.io.IOException;
import java.util.List;
import com.arquitecturajava.helpers.LibroAR;
import jakarta.servlet.RequestDispatcher;
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


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher despachador = null;
    try {
      if (req.getParameter("accion") == null) {
        // Delega en la capa de persistencia
        List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();
        req.setAttribute("listaCategorias", listaCategorias);
        
        List<LibroAR> listaLibros = LibroAR.buscarTodos();
        req.setAttribute("listaLibros", listaLibros);
        
        despachador = req.getRequestDispatcher("listalibros.jsp");
        despachador.forward(req, resp);

      } else if (req.getParameter("accion").equals("formularionuevolibro")) {
        List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();
        req.setAttribute("listaCategorias", listaCategorias);
        despachador = req.getRequestDispatcher("formularionuevolibro.jsp");
        despachador.forward(req, resp);
      } else if (req.getParameter("accion").equals("insertarlibro")) {
        String isbn = req.getParameter("isbn");
        String titulo = req.getParameter("titulo");
        String categoria = req.getParameter("categoria");

        LibroAR libroAR = new LibroAR(isbn, titulo, categoria);
        libroAR.insertar();

        List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();
        List<LibroAR> listaLibros = LibroAR.buscarTodos();

        req.setAttribute("listaCategorias", listaCategorias);
        req.setAttribute("listaLibros", listaLibros);

        despachador = req.getRequestDispatcher("listalibros.jsp");
        despachador.forward(req, resp);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }

}
