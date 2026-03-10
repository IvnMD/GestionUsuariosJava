package com.docencia.service;

import java.util.Set;

import com.docencia.model.Usuario;

/**
 * @author IvnMD
 * @date 08/03/26
 * @version 1.0.0
 * @brief Interfaz del servicio de usuario
 */
public interface IUserService {

  /**
   * Crea un nuevo usuario y lo persiste en el repositorio
   * 
   * @param id       identificador unico de la persona
   * @param nombre   nombre de la persona
   * @param email    email del usuario
   * @param password contrasenya del usuario
   * @return Usuario creado o null si y lo estaba
   * @throws IllegalArgumentException si el email ya esta registrado
   */
  Usuario crearUsuario(int id, String nombre, String email, String password);

  /**
   * Retorna todos los usuarios almacenados en el repositorio
   * 
   * @return Set con todos los usuarios registrados
   */
  Set<Usuario> listarUsuarios();

  /**
   * Funcion que retorna un usuario a tracer de su email
   * 
   * @param email String con el email del usuario
   * @return Objeto de la clase usuario
   */
  Usuario buscarPorEmail(String email);

  /**
   * Elimina un usuario del repositorio buscando por su email
   * 
   * @param email String con el email del usuario a eliminar
   * @return true si se elimino correctamente, false si no existia
   */
  boolean eliminarPorEmail(String email);

  /**
   * Cambia el nombre de un usuario existente
   * 
   * @param email email del usuario a modificar
   * @param nuevoNombre nuevo nombre para el usuario
   * @return Usuario con nuevo nombre
   * @throws IllegalArgumentException si el email no es valido o usuario no existe
   */
  Usuario cambiarNombre(String email, String nuevoNombre);

  /**
   * Cambia la contrasena de un usuario existente
   * 
   * @param email email del usuario a modificar
   * @param nuevaPassword nueva contrasenya que se asignara al usuario
   * @return Usuario con nueva contrasenys
   * @throws IllegalArgumentException si el email no es valido o usuario no existe
   */
  Usuario cambiarPassword(String email, String nuevaPassword);
}
