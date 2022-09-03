package com.pablo.portafolio.persistence.crud;

import com.pablo.portafolio.persistence.models.InstitucionDAO;
import org.springframework.data.repository.CrudRepository;

public interface InstitucionCrudRepository extends CrudRepository<InstitucionDAO, Integer> {
}
