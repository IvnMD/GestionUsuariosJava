package com.docencia.util;

import java.util.regex.Pattern;

/**
 * @author IvnMD
 * @date 02/03/2026
 * @version 1.0.0
 * 
 * @brief metodos utiles para validr los documentos
 */
public class Validaciones {

    /**
     * Validacion de la contraseña
     * 
     * @param password del usuario
     * @return true o false
     * @throws IllegalArgumentException si el password no cumple el patron
     */
    public static boolean passwordValida(String password) {
        String patron = "^\\w{6,}$";

        return Pattern.matches(patron, password);

    }

    /**
     * Validacion del email
     * 
     * @param email de la poersona
     * @return true o false
     * @throws IllegalArgumentException si el email no cumple el patron
     */
    public static boolean emailValido(String email) {
        String patron = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"; // ! IMPORTANTISIMO, RECUERDA "\\." PARA ESCAPAR EL PUNTO
                                                          // ! (recuerda revisar si en el examen te fallo eso)
        if (!Pattern.matches(patron, email)) {
            return false;
        }
        // return Pattern.matches(patron, email);
        return email.matches(patron); // ! Metodo Jorge. En vez de varible podria ir directamente la RegEX
    }

    /**
     * Funcion que normaliza el email
     * 
     * @param email
     * @return email normalizado y en minusculas
     * @throws IllegalArgumentException si el email es nulo o vacio
     */
    public static String normalizarEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email nulo o vacio");
        }
        return email.trim().toLowerCase();

    }

    /**
     * Funcion que valida el nombre (Debe tener al menos 5 caracteres sin espacios)
     * 
     * @param nombre de la persona
     * 
     */
    public static void validarNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("Nombre nulo");
        }
        nombre = nombre.trim();
        if (nombre.length() < 5) {
            throw new IllegalArgumentException("Nombre demasiado corto");
        }
    }

    /**
     * Funcion que valida un email
     * 
     * @param email String con el email del usuairo
     * @throws IllegalArgumentException si el email no tiene formato valido
     */
    public static void validarEmail(String email) {
        if (emailValido(email) == false) {
            throw new IllegalArgumentException("Email no valido");
        }
    }

    /**
     * Funcion que valida una cantrasenya
     * 
     * @param password String con el password del usuario
     * @throws IllegalArgumentException si la contrasena no cumple el patron
     */
    public static void validarPassword(String password) {
        if (!passwordValida(password)) {
            throw new IllegalArgumentException("Password invalido");
        }
    }
}
