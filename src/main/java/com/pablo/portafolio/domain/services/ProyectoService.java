package com.pablo.portafolio.domain.services;

import com.pablo.portafolio.domain.entity.Proyecto;
import com.pablo.portafolio.domain.gateway.ProyectoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoGateway gateway;

    public List<Proyecto> getAll(){ return gateway.getAll(); }
    public Optional<Proyecto> getProyectoById(int idProyecto){ return gateway.getProyectoById(idProyecto);}
    public Proyecto saveProyecto(Proyecto proyecto){return gateway.saveProyecto(proyecto);}
    public void deleteProyecto(int idProyecto){ gateway.deleteProyecto(idProyecto);}


}
