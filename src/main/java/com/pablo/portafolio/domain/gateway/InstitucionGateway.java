package com.pablo.portafolio.domain.gateway;

import com.pablo.portafolio.domain.entity.Institucion;

import java.util.List;
import java.util.Optional;

public interface InstitucionGateway {

    List<Institucion> getAll();
    Optional<Institucion> getInstitucionbyId(int idInstitucion);
    Institucion saveInstitucion(Institucion institucion);
    void deleteInstitucion(int idInstitucion);

    List<Institucion> findBynombreTituloContains(String nivel_filtro);

}
