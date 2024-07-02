/**
 * 
 */
package com.rellabacode.controllers.commands;

import java.util.List;
import com.rellabacode.helpers.Libro;
import com.rellabacode.repositories.LibroRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Comando concreto para filtrar libros por categoría
 */
public class FiltroLibroCategoriaCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String categoria = request.getParameter("categoria");
    LibroRepository repository = new LibroRepository();
    List<Libro> listaLibros = repository.buscarTodosPorCategoria(categoria);
    List<String> listaCategorias = repository.buscarTodasLasCategorias();

    request.setAttribute("listaCategorias", listaCategorias);
    request.setAttribute("listaLibros", listaLibros);
    request.setAttribute("filtroCategoria", categoria);
    
    RequestDispatcher despachador = request.getRequestDispatcher("listalibros.jsp");
    despachador.forward(request, response);
    
  }

}
