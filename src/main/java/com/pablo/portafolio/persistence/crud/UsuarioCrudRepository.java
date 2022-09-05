package com.pablo.portafolio.persistence.crud;

import com.pablo.portafolio.persistence.models.UsuarioDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioCrudRepository extends CrudRepository<UsuarioDAO, Long> {

    public List<UsuarioDAO> findByciudadContains(String ciudad);
    public List<UsuarioDAO> findBypaisContains(String pais);

    public List<UsuarioDAO> findBydisponibleExtranjero(boolean disponibleExtranjero);
}
