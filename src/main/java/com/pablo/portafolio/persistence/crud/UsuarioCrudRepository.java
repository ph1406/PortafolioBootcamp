package com.pablo.portafolio.persistence.crud;

import com.pablo.portafolio.persistence.models.UsuarioDAO;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<UsuarioDAO, Long> {
}
