package com.pablo.portafolio.domain.gateway;

import com.pablo.portafolio.domain.entity.Portafolio;

import java.util.List;
import java.util.Optional;

public interface PortafolioGateway {

    List<Portafolio> getAll();
    Optional<Portafolio> getPortafolioById(int idPortafolio);

    Portafolio savePortafolio(Portafolio portafolio);

    void deletePortafolio(int idPortafolio);

}
