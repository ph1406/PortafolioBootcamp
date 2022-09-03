package com.pablo.portafolio.persistence;

import com.pablo.portafolio.domain.entity.Portafolio;
import com.pablo.portafolio.domain.gateway.PortafolioGateway;
import com.pablo.portafolio.persistence.crud.PortafolioCrudRepository;
import com.pablo.portafolio.persistence.mappers.PortafolioMapper;
import com.pablo.portafolio.persistence.models.PortafolioDAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class PortafolioRepository implements PortafolioGateway {

    private PortafolioCrudRepository crudRepository;
    private PortafolioMapper mapper;

    public PortafolioRepository(PortafolioCrudRepository crudRepository, PortafolioMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Portafolio> getAll() {
        List<PortafolioDAO> lstPorta = (List<PortafolioDAO>) crudRepository.findAll();

        List<Portafolio> lstPor = mapper.toPortafolios(lstPorta);
        return lstPor;
    }

    @Override
    public Optional<Portafolio> getPortafolioById(int idPortafolio) {
        return crudRepository.findById(idPortafolio).map(td->mapper.toPortafolio(td));
    }

    @Override
    public Portafolio savePortafolio(Portafolio portafolio) {
        PortafolioDAO porta = crudRepository.save(mapper.toPortafolioDao(portafolio));
        return mapper.toPortafolio(porta);
    }

    @Override
    public void deletePortafolio(int idPortafolio) {
        crudRepository.deleteById(idPortafolio);
    }
}
