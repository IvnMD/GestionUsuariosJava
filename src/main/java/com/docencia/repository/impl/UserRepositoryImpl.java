package com.docencia.repository.impl;

import java.util.HashSet;
import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.util.Validaciones;
/**
 * @author IvnMD
 * @date 08/03/26
 * @version 1.0.0
 * @brief Implementación del repositorio de usuarios usando un HashSet en memoria
 */
public class UserRepositoryImpl implements IUserRepository {
    final Set<Usuario> usuarios;

    /**
     * Construcotr que inicializa un set vacio
     */
    public UserRepositoryImpl() {
        usuarios = new HashSet<>();
    }

    @Override
    public Usuario findByEmail(String email) {
        email = Validaciones.normalizarEmail(email);
        if (!existsByEmail(email)) {
            return null;
        }

        Usuario usuarioBuscar = new Usuario((email));
        for (Usuario usuario : usuarios) {
            if (usuario.equals(usuarioBuscar)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        email = Validaciones.normalizarEmail(email);
        Usuario usuarioBuscar = new Usuario(email);
        return usuarios.contains(usuarioBuscar);
    }

    @Override
    public void save(Usuario usuario) {
        usuarios.add(usuario);

    }


    @Override
    public Set<Usuario> findAll() {
        return usuarios;
    }

    @Override
    public boolean deleteByEmail(String email) {
        email = Validaciones.normalizarEmail(email);
        return usuarios.remove(new Usuario(email));
    }
}
