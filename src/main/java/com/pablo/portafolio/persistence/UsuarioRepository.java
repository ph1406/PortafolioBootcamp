package com.pablo.portafolio.persistence;

import com.pablo.portafolio.domain.entity.Usuario;
import com.pablo.portafolio.domain.gateway.UsuarioGateway;
import com.pablo.portafolio.persistence.crud.UsuarioCrudRepository;
import com.pablo.portafolio.persistence.mappers.UsuarioMapper;
import com.pablo.portafolio.persistence.models.UsuarioDAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class UsuarioRepository implements UsuarioGateway {

    private UsuarioCrudRepository crudRepository;
    private UsuarioMapper mapper;

    public UsuarioRepository(UsuarioCrudRepository crudRepository, UsuarioMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Usuario> getAll() {

        List<UsuarioDAO> daos = (List<UsuarioDAO>) crudRepository.findAll();
        List<Usuario> usuarios = mapper.toUsuarios(daos);
        return usuarios;
    }

    @Override
    public Optional<Usuario> getUsuarioByRut(long rut) {
        return crudRepository.findById(rut).map(td-> mapper.toUsuario(td));
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
       UsuarioDAO udao = mapper.toUsuarioDao(usuario);
       return mapper.toUsuario(crudRepository.save(udao));
    }

    @Override
    public void deleteUsuario(long rut) {
        crudRepository.deleteById(rut);
    }

    @Override
    public List<Usuario> getByciudadContains(String ciudad) {
        List<UsuarioDAO> daos = (List<UsuarioDAO>) crudRepository.findByciudadContains(ciudad);
        List<Usuario> usuarios = mapper.toUsuarios(daos);
        return usuarios;
    }

    @Override
    public List<Usuario> getBypaisContains(String pais) {
        List<UsuarioDAO> daos = (List<UsuarioDAO>) crudRepository.findBypaisContains(pais);
        List<Usuario> usuarios = mapper.toUsuarios(daos);
        return usuarios;
    }

    @Override
    public List<Usuario> getBydisponibleExtranjero(boolean disponibleExtranjero) {
        List<UsuarioDAO> daos = (List<UsuarioDAO>) crudRepository.findBydisponibleExtranjero(disponibleExtranjero);
        List<Usuario> usuarios = mapper.toUsuarios(daos);
        return usuarios;
    }
}
