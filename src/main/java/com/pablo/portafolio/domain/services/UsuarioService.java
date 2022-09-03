package com.pablo.portafolio.domain.services;

import com.pablo.portafolio.domain.entity.Usuario;
import com.pablo.portafolio.domain.gateway.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioGateway gateway;

    public List<Usuario> getAll(){return gateway.getAll();}
    public Optional<Usuario> getUsuarioByRut(long rut){return gateway.getUsuarioByRut(rut);}
    public Usuario saveUsuario(Usuario usuario){return gateway.saveUsuario(usuario);}
    public void deleteUsuario(long rut){gateway.deleteUsuario(rut);}

}
