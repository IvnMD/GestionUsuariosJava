package com.docencia.service.impl;

import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.service.IUserService;
import com.docencia.util.Validaciones;

/**
 * @author IvnMD
 * @date 08/03/26
 * @version 1.0.0
 * @brief Inplementacion del servicio de usuario
 */
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Usuario crearUsuario(int id, String nombre, String email, String password) {
        if (id < 1)
            throw new IllegalArgumentException("Id invalido");
        Validaciones.validarEmail(email);
        Validaciones.validarPassword(password);
        email = Validaciones.normalizarEmail(email);

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        Usuario usuario = new Usuario(id, nombre, email, password);
        userRepository.save(usuario);
        return usuario;
    }

    @Override
    public Set<Usuario> listarUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean eliminarPorEmail(String email) {
        if (!Validaciones.emailValido(email)) {
            return false;
        }
        email = Validaciones.normalizarEmail(email);
        return userRepository.deleteByEmail(email);
    }

    @Override
    public Usuario cambiarNombre(String email, String nuevoNombre) {
      
        email = Validaciones.normalizarEmail(email);
        Validaciones.validarEmail(email);
        Validaciones.validarNombre(nuevoNombre);

        Usuario usuario = userRepository.findByEmail(email);
        usuario.setNombre(nuevoNombre);

        return usuario;
    }

    @Override
    public Usuario cambiarPassword(String email, String nuevaPassword) {
        
        email = Validaciones.normalizarEmail(email);
        Validaciones.validarEmail(email);
        Validaciones.validarPassword(nuevaPassword);

        Usuario usuario = userRepository.findByEmail(email);
        usuario.setPassword(nuevaPassword);

        return usuario;
    }

}
