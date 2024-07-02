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
 * Comando concreto para insertar un libro
 */
public class InsertarLibroCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");

    Libro libro = new Libro(isbn, titulo, categoria);
    LibroRepository libroRepository = new LibroRepository();
    libroRepository.insertar(libro);

    List<String> listaCategorias = libroRepository.buscarTodasLasCategorias();
    List<Libro> listaLibros = libroRepository.buscarTodos();

    request.setAttribute("listaCategorias", listaCategorias);
    request.setAttribute("listaLibros", listaLibros);
    
    RequestDispatcher despachador = request.getRequestDispatcher("listalibros.jsp");
    despachador.forward(request, response);
  }



}
