package com.arquitecturajava.helpers;

import java.sql.ResultSet;

public class LibroAR {

	public static ResultSet buscarTodasLasCategorias() {
		String consultaCategoria = "SELECT distinct(categoria) FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consultaCategoria);
		return resultSet;
	}

	public static void insertar(String isbn, String titulo, String categoria) {
		String consultaInsercion = "INSERT INTO libros (isbn, titulo, categoria) VALUES(?, ?, ?)";
		DatabaseHelper.executeUpdate(consultaInsercion, isbn, titulo, categoria);
	}

	public static ResultSet buscarTodos() {
		String consulta = "SELECT * FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consulta);
		return resultSet;
	}

}
