package com.pablo.portafolio.persistence.crud;

import com.pablo.portafolio.persistence.models.InstitucionDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InstitucionCrudRepository extends CrudRepository<InstitucionDAO, Integer> {

    public List<InstitucionDAO> findBynombreTituloContains(String nivel_filtro);

}
