package com.rellabacode.helpers;

//Active Record Pattern
//Capa de negocio
public class Libro {

  //Responsabilidad negocio
  private String isbn;
  private String titulo;
  private String categoria;
  
  public Libro(String isbn) {
    super();
    this.isbn = isbn;
  }

  public Libro(String isbn, String titulo, String categoria) {
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
}
