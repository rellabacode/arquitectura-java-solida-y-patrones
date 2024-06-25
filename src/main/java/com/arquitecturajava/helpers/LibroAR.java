package com.arquitecturajava.helpers;

import java.sql.ResultSet;

public class LibroAR {

  private String isbn;
  private String titulo;
  private String categoria;

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

  public static ResultSet buscarTodasLasCategorias() {
    String consultaCategoria = "SELECT distinct(categoria) FROM libros";
    ResultSet resultSet = DatabaseHelper.executeQuery(consultaCategoria);
    return resultSet;
  }

  public static ResultSet buscarTodosPorCategoria(String categoria) {
    String consultaCategoria = "SELECT * FROM libros where categoria=?";
    ResultSet resultSet = DatabaseHelper.executeQuery(consultaCategoria, categoria);
    return resultSet;
  }

  public void insertar() {
    String consultaInsercion = "INSERT INTO libros (isbn, titulo, categoria) VALUES(?, ?, ?)";
    DatabaseHelper.executeUpdate(consultaInsercion, isbn, titulo, categoria);
  }

  public static ResultSet buscarTodos() {
    String consulta = "SELECT * FROM libros";
    ResultSet resultSet = DatabaseHelper.executeQuery(consulta);
    return resultSet;
  }

}
