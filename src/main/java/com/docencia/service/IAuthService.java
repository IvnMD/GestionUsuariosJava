package com.docencia.service;

import com.docencia.model.Usuario;

/**
 * @author IvnMD
 * @date 08/03/26
 * @version 1.0.0
 * @brief Interfaz del servicio de autenticacion
 */
public interface IAuthService {

    /**
     * Valida si un email tiene formato correcto
     * 
     * @param email a validar
     * @return true si el formato es valido, false si no
     */
    public boolean validacionEmail(String email);

    /**
     * Funcion que permite registrar un usuario
     * 
     * @param id unico de la persona
     * @param nombre de la persona
     * @param email unico del usuario
     * @param password del usuario
     * @return Usuario dentro del sistema
     */
    Usuario register(int id, String nombre, String email, String password);

    /**
     * Inicia sesion comprobando las credenciales del usuario
     * Incrementa los intentos fallidos si la contrasena es incorrecta
     * Bloquea la cuenta tras superar el maximo de intentos fallidos
     * 
     * @param email del usuario
     * @param password contrasena introducida
     * @return true si las credenciales son correctas y la cuenta no esta bloqueada, false en caso contrario
     */
    boolean login(String email, String password);

    /**
     * Comprueba si la cuenta de un usuario esta bloqueada
     * 
     * @param email email del usuario a consultar
     * @return true si la cuenta esta bloqueada, false si no existe o no esta bloqueada
     */
    boolean isBloqueado(String email);

    /**
     * Desbloquea la cuenta de un usuario y resetea a 0 sus intentos fallidos
     * 
     * @param email email del usuario a desbloquear
     * @throws IllegalArgumentException si el email no es valido o el usuario no existe
     */
    void desbloquear(String email);

}
