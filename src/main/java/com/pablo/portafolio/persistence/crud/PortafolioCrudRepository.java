package com.pablo.portafolio.persistence.crud;

import com.pablo.portafolio.persistence.models.PortafolioDAO;
import org.springframework.data.repository.CrudRepository;

public interface PortafolioCrudRepository extends CrudRepository<PortafolioDAO, Integer> {
}
