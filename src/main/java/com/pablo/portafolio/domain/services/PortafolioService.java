package com.pablo.portafolio.domain.services;


import com.pablo.portafolio.domain.entity.Portafolio;
import com.pablo.portafolio.domain.gateway.PortafolioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortafolioService {

    @Autowired
    private PortafolioGateway gateway;

    public List<Portafolio> getAll(){ return gateway.getAll(); }
    public Optional<Portafolio> getPortafolioById(int idPortafolio){ return gateway.getPortafolioById(idPortafolio); }
    public Portafolio savePortafolio(Portafolio portafolio){ return gateway.savePortafolio(portafolio);}
    public void deletePortafolio(int idPortafolio){ gateway.deletePortafolio(idPortafolio);}


}
