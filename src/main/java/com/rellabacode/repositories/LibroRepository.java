package com.rellabacode.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.rellabacode.helpers.DatabaseHelper;
import com.rellabacode.helpers.Libro;

// Patrón Repository para cumplir ISP sobre la clase libro
public class LibroRepository {
  public List<String> buscarTodasLasCategorias() throws Exception {
    List<String> lista = new ArrayList<String>();
    lista.add("");
    String consultaCategoria = "SELECT distinct(categoria) FROM libros ORDER BY categoria asc";
    ResultSet resultSet = DatabaseHelper.executeQuery(consultaCategoria);
    while (resultSet.next()) {
      lista.add(resultSet.getString("categoria"));
    }    
    DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(),
        resultSet);
    return lista;
  }

  public void insertar(Libro libro) throws Exception {
    String consultaInsercion = "INSERT INTO libros (isbn, titulo, categoria) VALUES (?, ?, ?)";
    DatabaseHelper.executeUpdate(consultaInsercion, libro.getIsbn(), libro.getTitulo(),
        libro.getCategoria());
  }

  // Programar hacia la interfaz
  public List<Libro> buscarTodos() {
    List<Libro> lista = new ArrayList<Libro>();
    String consulta = "SELECT * FROM libros ORDER BY titulo asc";
    ResultSet resultSet = DatabaseHelper.executeQuery(consulta);
    try {
      while (resultSet.next()) {
        lista.add(new Libro(resultSet.getString("isbn"), resultSet.getString("titulo"),
            resultSet.getString("categoria")));
      }
    } catch (SQLException e) {
      // no hace falta capturarlas en cada capa
      throw new RuntimeException(e);
    } finally {
      try {
        DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(),
            resultSet);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }

    return lista;
  }

  public List<Libro> buscarTodosPorCategoria(String categoria) throws SQLException {
    List<Libro> lista = new ArrayList<Libro>();
    String consultaCategoria = "SELECT * FROM libros where categoria=? ORDER BY titulo asc";
    ResultSet resultSet = null;

    if (!"".equals(categoria)) {
      resultSet = DatabaseHelper.executeQuery(consultaCategoria, categoria);
    } else {
      consultaCategoria = "SELECT * FROM libros ORDER BY titulo asc";
      resultSet = DatabaseHelper.executeQuery(consultaCategoria);
    }

    while (resultSet.next()) {
      lista.add(new Libro(resultSet.getString("isbn"), resultSet.getString("titulo"),
          resultSet.getString("categoria")));
    }
    DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(),
        resultSet);
    return lista;
  }

  public void borrar(String isbn) throws Exception {
    String consultaBorrado = "delete from libros where isbn=?";
    DatabaseHelper.executeUpdate(consultaBorrado, isbn);
  }
}
