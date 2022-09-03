package com.pablo.portafolio.persistence.mappers;


import com.pablo.portafolio.domain.entity.Institucion;
import com.pablo.portafolio.persistence.models.InstitucionDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstitucionMapper {

    @Mappings({
            @Mapping(source="idInstitucion", target="idInstitucion"),
            @Mapping(source="nombreInstitucion", target="nombreInstitucion"),
            @Mapping(source="idPortafolio", target="idPortafolio"),
            @Mapping(source="nombreTitulo", target="nombreTitulo"),
            @Mapping(source="tipoInstitucion", target="tipoInstitucion"),
            @Mapping(source="anio_inicio", target="anio_inicio"),
            @Mapping(source="anio_termino", target="anio_termino")
    })
    Institucion toInstitucion(InstitucionDAO dao);


    List<Institucion> toInstituciones(List<InstitucionDAO> daos);


    @InheritInverseConfiguration
    @Mapping(target = "portafolio", ignore = true)
    InstitucionDAO toInstitucionDao(Institucion dao);

}
