package com.pablo.portafolio.persistence.mappers;


import com.pablo.portafolio.domain.entity.Portafolio;
import com.pablo.portafolio.persistence.models.PortafolioDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface PortafolioMapper {


    @Mappings({
            @Mapping(source = "idPortafolio", target = "idPortafolio"),
            @Mapping(source = "aliasPortafolio", target = "aliasPortafolio"),
            @Mapping(source = "rut", target = "rut"),
            @Mapping(source = "usuario", target = "usuario")
    })
    Portafolio toPortafolio(PortafolioDAO dao);


    List<Portafolio> toPortafolios(List<PortafolioDAO> daos);


    @InheritInverseConfiguration
    @Mapping(target = "educacion", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "experiencia", ignore = true)
    PortafolioDAO toPortafolioDao(Portafolio dao);


}
