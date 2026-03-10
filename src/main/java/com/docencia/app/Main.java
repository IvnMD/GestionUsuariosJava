package com.docencia.app;

import java.util.Scanner;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.repository.impl.UserRepositoryImpl;
import com.docencia.service.IAuthService;
import com.docencia.service.IUserService;
import com.docencia.service.impl.AuthServiceImpl;
import com.docencia.service.impl.UserServiceImpl;

/**
 * 
 * @author IvnMD
 * @date 08/03/26
 * @version 1.0.0
 * @brief Programa main para probar las funciones desarrolladas
 * 
 */
public class Main {

  private static final Scanner SC = new Scanner(System.in);

  public static void main(String[] args) {

    IUserRepository userRepository = new UserRepositoryImpl();
    IUserService userService = new UserServiceImpl(userRepository);
    IAuthService authService = new AuthServiceImpl(userRepository);

    boolean running = true;
    while (running) {
      mostrarMenu();
      int op = leerOpcion();
      try {
        switch (op) {
          case 1 -> registrar(authService);
          case 2 -> login(authService);
          case 3 -> listar(userService);
          case 4 -> buscar(userService);
          case 5 -> eliminar(userService);
          case 6 -> cambiarNombre(userService); 
          case 7 -> cambiarPassword(userService);
          case 8 -> desbloquear(authService);
          case 9 -> comprobarBloqueo(authService);
          case 0 -> running = false;
          default -> System.out.println("Opción no válida");
        }
      } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
      }
      System.out.println();
    }
    System.out.println("Hasta pronto.");
  }

  private static void mostrarMenu() {
    System.out.println("===== SISTEMA DE AUTENTICACION =====");
    System.out.println("1) Registrar usuario");
    System.out.println("2) Iniciar sesion");
    System.out.println("3) Listar usuarios");
    System.out.println("4) Buscar por email");
    System.out.println("5) Eliminar usuario");
    System.out.println("6) Cambiar nombre");
    System.out.println("7) Cambiar password");
    System.out.println("8) Desbloquear usuario");
    System.out.println("9) Comprobar si esta bloqueado");
    System.out.println("0) Salir");
  }

  private static int leerOpcion() {
    System.out.print("Elige una opción: ");
    try {
      return Integer.parseInt(SC.nextLine().trim());
    } catch (Exception e) {
      return -1;
    }
  }

  private static void registrar(IAuthService auth) {
    System.out.print("ID: ");
    int id = Integer.parseInt(SC.nextLine().trim());
    System.out.print("Nombre: ");
    String nombre = SC.nextLine();
    System.out.print("Email: ");
    String email = SC.nextLine();
    System.out.print("Password: ");
    String pass = SC.nextLine();

    auth.register(id, nombre, email, pass);
    System.out.println("Usuario registrado correctamente."); //! Habria que añadir una forma de imprimir cuando la creacion de un usuario da error. 
  }

  private static void login(IAuthService auth) {
    System.out.print("Email: ");
    String email = SC.nextLine();
    System.out.print("Password: ");
    String pass = SC.nextLine();

    boolean ok = auth.login(email, pass);
    System.out.println(ok ? "✅ Login correcto" : "❌ Login incorrecto"); //! Lo ideal seria que al hacer login incorrecto, dijese numero de intentos restantes
  }

  private static void listar(IUserService users) {
    users.listarUsuarios().forEach(System.out::println);
  }

  private static void buscar(IUserService users) {
    System.out.print("Email a buscar: ");
    String email = SC.nextLine();
    var u = users.buscarPorEmail(email);
    if (u == null) {
      System.out.println("No encontrado");
    } else {
      System.out.println(u.toString());
    }
  }

  private static void eliminar(IUserService users) {
    System.out.print("Email a eliminar: ");
    String email = SC.nextLine();
    boolean ok = users.eliminarPorEmail(email);
    System.out.println(ok ? "Eliminado." : "No existía.");
  }

  /**
   * Metodos desarrollas con IA para poder profar las funciones desarrolladas
   */
  private static void cambiarNombre(IUserService users) {
    System.out.print("Email: ");
    String email = SC.nextLine();
    System.out.print("Nuevo nombre: ");
    String nuevoNombre = SC.nextLine();
    Usuario u = users.cambiarNombre(email, nuevoNombre);
    System.out.println("Nombre actualizado: " + u.getNombre());
  }

  private static void cambiarPassword(IUserService users) {
    System.out.print("Email: ");
    String email = SC.nextLine();
    System.out.print("Nueva password: ");
    String nuevaPassword = SC.nextLine();
    users.cambiarPassword(email, nuevaPassword);
    System.out.println("Password actualizada correctamente.");
  }

  private static void desbloquear(IAuthService auth) {
    System.out.print("Email a desbloquear: ");
    String email = SC.nextLine();
    auth.desbloquear(email);
    System.out.println("Usuario desbloqueado correctamente.");
  }

  private static void comprobarBloqueo(IAuthService auth) {
    System.out.print("Email a comprobar: ");
    String email = SC.nextLine();
    boolean bloqueado = auth.isBloqueado(email);
    System.out.println(bloqueado ? "El usuario esta bloqueado." : "El usuario no esta bloqueado.");
  }

}