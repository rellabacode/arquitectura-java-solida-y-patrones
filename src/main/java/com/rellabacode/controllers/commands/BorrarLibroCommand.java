/**
 * 
 */
package com.rellabacode.controllers.commands;

import com.rellabacode.helpers.Libro;
import com.rellabacode.repositories.LibroRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Comando concreto para borrar un libro
 */
public class BorrarLibroCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String isbn = request.getParameter("isbn");
    Libro libroAR = new Libro(isbn);
    LibroRepository libroRepository = new LibroRepository();
    libroRepository.borrar(libroAR.getIsbn());
    
    response.sendRedirect(request.getRequestURL().toString());
  }

}
