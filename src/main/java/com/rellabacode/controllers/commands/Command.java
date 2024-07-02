package com.rellabacode.controllers.commands;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Interfaz común a todos los comandos concretos
 */
public interface Command {
  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
