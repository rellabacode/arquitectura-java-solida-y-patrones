/**
 * 
 */
package com.rellabacode.controllers.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Router con todas las operaciones de navegación. Con un fichero podría cumplir mejor el OCP
 */
public class Router {

  private static Map<String, Command> mapa = new HashMap<String, Command>();
  static {
    mapa.put("listalibro", new ListaLibrosCommand());
    mapa.put("formularionuevolibro", new FormularioNuevoLibroCommand());
    mapa.put("insertarlibro", new InsertarLibroCommand());
    mapa.put("borrarlibro", new BorrarLibroCommand());
    mapa.put("filtrocategorialibro", new FiltroLibroCategoriaCommand());
  }

  public static Command getCommand(String nombreComando) {
    if (nombreComando == null) {
      return mapa.get("listalibro");

    } else {
      return mapa.get(nombreComando);
    }
  }
}
