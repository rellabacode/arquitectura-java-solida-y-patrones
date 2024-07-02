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
 * Comando concreto para listar todos los libros
 */
public class ListaLibrosCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    LibroRepository repositorio = new LibroRepository();

    List<String> listaCategorias = repositorio.buscarTodasLasCategorias();
    List<Libro> listaLibros = repositorio.buscarTodos();

    request.setAttribute("listaCategorias", listaCategorias);
    request.setAttribute("listaLibros", listaLibros);
    RequestDispatcher despachador = request.getRequestDispatcher("listalibros.jsp");
    despachador.forward(request, response);

  }

}
