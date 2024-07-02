/**
 * 
 */
package com.rellabacode.controllers.commands;

import java.util.List;
import com.rellabacode.repositories.LibroRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Comando concreto para solicitar un libro al usuario 
 */
public class FormularioNuevoLibroCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    LibroRepository repositorio = new LibroRepository();
    List<String> listaCategorias = repositorio.buscarTodasLasCategorias();
    request.setAttribute("listaCategorias", listaCategorias);

    RequestDispatcher despachador = request.getRequestDispatcher("formularionuevolibro.jsp");
    despachador.forward(request, response);
  }

}
