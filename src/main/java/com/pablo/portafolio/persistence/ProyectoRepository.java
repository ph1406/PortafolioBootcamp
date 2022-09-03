package com.pablo.portafolio.persistence;

import com.pablo.portafolio.domain.entity.Proyecto;
import com.pablo.portafolio.domain.gateway.ProyectoGateway;
import com.pablo.portafolio.persistence.crud.ProyectoCrudRepository;
import com.pablo.portafolio.persistence.mappers.ProyectoMapper;
import com.pablo.portafolio.persistence.models.ProyectoDAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class ProyectoRepository implements ProyectoGateway {

    private ProyectoCrudRepository crudRepository;
    private ProyectoMapper mapper;

    public ProyectoRepository(ProyectoCrudRepository crudRepository, ProyectoMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Proyecto> getAll() {

        List<ProyectoDAO> lp = (List<ProyectoDAO>)crudRepository.findAll();
        return mapper.toProyectos(lp);

    }

    @Override
    public Optional<Proyecto> getProyectoById(int idProyecto) {
        return crudRepository.findById(idProyecto).map(td->mapper.toProyecto(td));
    }

    @Override
    public Proyecto saveProyecto(Proyecto proyecto) {
        ProyectoDAO pro = crudRepository.save(mapper.toProyectoDao(proyecto));
        return mapper.toProyecto(pro);
    }

    @Override
    public void deleteProyecto(int idProyecto) {
        crudRepository.deleteById(idProyecto);
    }
}
