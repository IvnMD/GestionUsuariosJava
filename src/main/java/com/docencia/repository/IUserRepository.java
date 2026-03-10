package com.docencia.repository;

import com.docencia.model.Usuario;

 
/**
 * Interfaz de la clase userRepository
 */
public interface IUserRepository {

    /**
     * Funcion que realiza la busqueda de un usuario
     * @param email String con email normalizado
     * @return true/false
     */
    public Usuario findByEmail(String email);

    /**
     * Funcion que comprueba si existe un email
     * @param email String con el email normalizado
     * @return true/false
     */
    public boolean existsByEmail(String email);
    
    /**
     * Funcion que guarda un usuario
     * @param usuario a guardar
     */
    public void save(Usuario usuario);

    /**
     * Funcion que lista todos los usuarios
     * @return Lista de todos los usuarios
     */
    public java.util.Set<Usuario> findAll();


    /**
     * Funcion que elimina un usuario buscando por su email
     * @param email del usuario a eliminar
     * @return true si elimina el usuario exitosamente, false si no existe el usuairo
     */
    public boolean deleteByEmail(String email);

    
        
    
}
