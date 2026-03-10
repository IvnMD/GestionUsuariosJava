/**
 * 
 * @author IvnMD
 * @date 04/03/26
 * @version 1.0.0
 * @brief Clase que define al usuario y hereda de persona
 * 
 */

package com.docencia.model;

import java.time.LocalDate;
import java.util.Objects;

import com.docencia.util.Validaciones;

public class Usuario extends Persona {
    private final String email;
    private String password;
    private int intentosFallidos;
    private boolean bloqueado;
    private final LocalDate fechaRegistro;

    /**
     * Constructor vacio/por defecto
     */
    public Usuario() {
        super();
        this.email = "";
        this.fechaRegistro = LocalDate.now();
    }

    /**
     * Constructor por idenfiticador unico de la clase
     * 
     * @param email email del usuairo
     */
    public Usuario(String email) {
        super();
        this.email = email;
        fechaRegistro = LocalDate.now();
    }

    /**
     * Constructor parametrico para el login
     * 
     * @param email            del usuairo
     * @param password         contrasenya del usuario
     * @param intentosFallidos numero de intentos fallidos en el login
     */
    public Usuario(String email, String password, int intentosFallidos) {
        this.email = email;
        this.password = password;
        this.intentosFallidos = intentosFallidos;
        this.bloqueado = false;
        this.fechaRegistro = LocalDate.now();
    }

    /**
     * Constructor parametrico
     * 
     * @param id       de la persona (identificador unico de la clase padre)
     * @param nombre   de la persona
     * @param email    del usuario (identificador unico de esta clase)
     * @param password contrasenya del usuario
     */
    public Usuario(int id, String nombre, String email, String password) {
        super(id, nombre);
        if (!Validaciones.emailValido(email.trim().toLowerCase())) {
            throw new IllegalArgumentException("Email no valido");
        }
        this.email = email;
        setPassword(password);
        this.fechaRegistro = LocalDate.now();
    }

    /**
     * Setters y getters
     */
    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        Validaciones.validarPassword(password);
        this.password = password;
    }

    public int getIntentosFallidos() {
        return this.intentosFallidos;
    }

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public boolean isBloqueado() {
        return this.bloqueado;
    }

    public boolean getBloqueado() {
        return this.bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public LocalDate getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void incrementarIntentosFallidos() {
        this.intentosFallidos++;
        if (this.intentosFallidos >= 3) {
            this.bloqueado = true;
        }
    }

    public void resetearIntentosFallidos() {
        this.intentosFallidos = 0;
    }

    public void bloquear() {
        this.bloqueado = true;
    }

    /**
     * funcion toString
     */
    @Override
    public String toString() {
        return "Usuario [nombre =" + getNombre()
                + ", email =" + getEmail()
                + ", password =" + getPassword()
                + ", num intentos fallidos =" + getIntentosFallidos()
                + ", bloqueado =" + isBloqueado()
                + ", fecha registro =" + getFechaRegistro() + "]";
    }

    /**
     * Equals y HashSet
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

}
