package com.pablo.portafolio.persistence.crud;

import com.pablo.portafolio.persistence.models.ProyectoDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProyectoCrudRepository extends CrudRepository<ProyectoDAO, Integer> {

    List<ProyectoDAO> findBytecnologiaContains(String tecnologia);
}
