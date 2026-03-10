/**
 * 
 * @author IvnMD
 * @date 04/03/26
 * @version 1.0.0
 * @brief Clase abstracta que define una persona
 * 
 */

package com.docencia.model;

import java.util.Objects;

abstract public class Persona {
    private final int id;
    private String nombre;

    /**
     * Constructor vacio/por defecto
     */
    protected Persona(){
        this.id = 0;
    }

    /**
     * Constructor por identificador unico
     * @param id
     */
    protected Persona(int id) {
        if (id <= 0) {
        throw new IllegalArgumentException("Id Invalido");
        }
        this.id = id;
    }
    /**
     * Constructor parametrico
     * @param id
     * @param nombre
     */
    protected Persona(int id, String nombre) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id invalido");
        }
        this.id = id;
        setNombre(nombre);
        
    }
    /**
     * Setters y getters
     */
    public int getId() {
        return id;
    }

    public int getId(int id) {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("Nombre nulo");
        }
        nombre = nombre.trim();
        if (nombre.length() < 5) {
            throw new IllegalArgumentException("Nombre demasiado corto");
        }
        this.nombre = nombre;
    }
    /**
     * HashCode, equals centrados en el identificador unico
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        return id == other.id;
    }

    /**
     * toString 
     */
    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + "]";
    }

    

}
