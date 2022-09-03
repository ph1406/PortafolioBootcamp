package com.pablo.portafolio.domain.gateway;

import com.pablo.portafolio.domain.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioGateway {

    List<Usuario> getAll();
    Optional<Usuario> getUsuarioByRut(long rut);
    Usuario saveUsuario(Usuario usuario);
    void deleteUsuario(long rut);
}
