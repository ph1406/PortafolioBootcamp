package com.pablo.portafolio.domain.gateway;

import com.pablo.portafolio.domain.entity.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoGateway {

    List<Proyecto> getAll();
    Optional<Proyecto> getProyectoById(int idProyecto);
    Proyecto saveProyecto(Proyecto proyecto);
    void deleteProyecto(int idProyecto);

}
