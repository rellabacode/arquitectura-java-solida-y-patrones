package com.arquitecturajava.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Active Record Pattern
//Capa de negocio
public class LibroAR {

  private String isbn;
  private String titulo;
  private String categoria;

  
  
  public LibroAR(String isbn) {
    super();
    this.isbn = isbn;
  }

  public LibroAR(String isbn, String titulo, String categoria) {
    super();
    this.isbn = isbn;
    this.titulo = titulo;
    this.categoria = categoria;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  //principio DRY
  public void borrar() {
    String consultaBorrado = "delete from libros where isbn=?";
    DatabaseHelper.executeUpdate(consultaBorrado, getIsbn());
  }


  public static List<String> buscarTodasLasCategorias() throws Exception {
    List<String> lista = new ArrayList<String>();
    String consultaCategoria = "SELECT distinct(categoria) FROM libros";
    ResultSet resultSet = DatabaseHelper.executeQuery(consultaCategoria);
    while (resultSet.next()) {
      lista.add(resultSet.getString("categoria"));
    }
    DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(),
        resultSet);
    return lista;
  }

  public static ResultSet buscarTodosPorCategoria(String categoria) {
    String consultaCategoria = "SELECT * FROM libros where categoria=?";
    ResultSet resultSet = DatabaseHelper.executeQuery(consultaCategoria, categoria);
    return resultSet;
  }

  //principio DRY
  public void insertar() {
    String consultaInsercion = "INSERT INTO libros (isbn, titulo, categoria) VALUES(?, ?, ?)";
    DatabaseHelper.executeUpdate(consultaInsercion, getIsbn(), getTitulo(), getCategoria());
  }

  //Programar hacia la interfaz
  public static List<LibroAR> buscarTodos() {
    List<LibroAR> lista = new ArrayList<LibroAR>();
    String consulta = "SELECT * FROM libros";
    ResultSet resultSet = DatabaseHelper.executeQuery(consulta);
    try {
      while (resultSet.next()) {
        lista.add(new LibroAR(resultSet.getString("isbn"), resultSet.getString("titulo"),
            resultSet.getString("categoria")));
      }
    } catch (SQLException e) {
      //no hace falta capturarlas en cada capa
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
}
