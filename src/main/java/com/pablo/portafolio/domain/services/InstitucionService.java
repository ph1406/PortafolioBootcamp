package com.pablo.portafolio.domain.services;

import com.pablo.portafolio.domain.entity.Institucion;
import com.pablo.portafolio.domain.gateway.InstitucionGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitucionService {

    @Autowired
    private InstitucionGateway gateway;

    public  List<Institucion> getBynombreTituloContains(String nivel_filtro){ return gateway.findBynombreTituloContains(nivel_filtro); };
    public List<Institucion> getAll(){ return gateway.getAll(); }
    public Optional<Institucion> getInstitucionById(int idInstitucion){ return gateway.getInstitucionbyId(idInstitucion); }
    public Institucion saveInstitucion(Institucion institucion){ return gateway.saveInstitucion(institucion);}
    public void deleteInstitucion(int idInstitucion){ gateway.deleteInstitucion(idInstitucion);}
}
