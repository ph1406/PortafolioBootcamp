package com.pablo.portafolio.persistence;

import com.pablo.portafolio.domain.entity.Institucion;
import com.pablo.portafolio.domain.gateway.InstitucionGateway;
import com.pablo.portafolio.persistence.crud.InstitucionCrudRepository;
import com.pablo.portafolio.persistence.mappers.InstitucionMapper;
import com.pablo.portafolio.persistence.models.InstitucionDAO;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class InstitucionRepository implements InstitucionGateway {

    private InstitucionCrudRepository crudRepository;
    private InstitucionMapper mapper;

    public InstitucionRepository(InstitucionCrudRepository crudRepository, InstitucionMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Institucion> getAll() {
        List<InstitucionDAO> lst = (List<InstitucionDAO>)crudRepository.findAll();
        List<Institucion> lsal = mapper.toInstituciones(lst);
        return lsal;
    }

    @Override
    public Optional<Institucion> getInstitucionbyId(int idInstitucion) {
        return crudRepository.findById(idInstitucion).map(td->mapper.toInstitucion(td));
    }

    @Override
    public Institucion saveInstitucion(Institucion institucion) {
       InstitucionDAO dao = mapper.toInstitucionDao(institucion);
       return mapper.toInstitucion(crudRepository.save(dao));
    }

    @Override
    public void deleteInstitucion(int idInstitucion) {
        crudRepository.deleteById(idInstitucion);
    }
}
