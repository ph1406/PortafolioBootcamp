package com.pablo.portafolio.persistence.crud;

import com.pablo.portafolio.persistence.models.ProyectoDAO;
import org.springframework.data.repository.CrudRepository;

public interface ProyectoCrudRepository extends CrudRepository<ProyectoDAO, Integer> {
}
