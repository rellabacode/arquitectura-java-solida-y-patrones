package com.rellabacode.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Creada aplicando el principio DRY
//Capa de persistencia - Responsabilidad: persistir los datos 
public class DatabaseHelper {
  private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/biblioteca";
  private static final String USUARIO = "root";
  private static final String CONTRASEÑA = "";

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new ExceptionInInitializerError("Error al cargar el driver de MySQL");
    }
  }

  // Método para cerrar la conexión y liberar recursos
  public static void close(Connection connection, Statement statement, ResultSet resultSet) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Método para ejecutar consultas de selección
  public static ResultSet executeQuery(String sql, Object... parameters) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = getConnection();
      preparedStatement = connection.prepareStatement(sql);

      // Establecer parámetros de la consulta
      for (int i = 0; i < parameters.length; i++) {
        preparedStatement.setObject(i + 1, parameters[i]);
      }

      // Establecer parámetros de la consulta
      for (int i = 0; i < parameters.length; i++) {
        preparedStatement.setObject(i + 1, parameters[i]);
      }
      // Ejecutar la consulta de selección
      return preparedStatement.executeQuery();

    } catch (SQLException e) {
      e.printStackTrace();
      return null; // Devolver null en caso de error
    }

    // finally {
    // close(connection, preparedStatement, null);
    // }
  }

  // Método para ejecutar consultas de modificación (inserciones, actualizaciones,
  // eliminaciones)
  public static void executeUpdate(String sql, Object... parameters) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = getConnection();
      preparedStatement = connection.prepareStatement(sql);

      // Establecer parámetros de consulta
      for (int i = 0; i < parameters.length; i++) {
        preparedStatement.setObject(i + 1, parameters[i]);
      }
      
      // Ejecutar la consulta de modificación
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      close(connection, preparedStatement, null);
    }
  }

  // Método para obtener una conexión a la base de datos
  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(JDBC_URL, USUARIO, CONTRASEÑA);
  }

}
