package com.pablo.portafolio.persistence.mappers;

import com.pablo.portafolio.domain.entity.Proyecto;
import com.pablo.portafolio.persistence.models.ProyectoDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProyectoMapper {

    @Mappings({
            @Mapping(source = "idProyecto", target = "idProyecto"),
            @Mapping(source = "nombreEmpresa", target = "nombreEmpresa"),
            @Mapping(source = "cargo", target = "cargo"),
            @Mapping(source = "nombreProyecto", target = "nombreProyecto"),
            @Mapping(source = "ciudad", target = "ciudad"),
            @Mapping(source = "descripcion", target = "descripcion"),
            @Mapping(source = "tecnologia", target = "tecnologia"),
            @Mapping(source = "fecha_inicio", target = "fecha_inicio"),
            @Mapping(source = "fecha_termino", target = "fecha_termino"),
            @Mapping(source = "idPortafolio", target = "idPortafolio")
    })
    Proyecto toProyecto(ProyectoDAO dao);

    List<Proyecto> toProyectos(List<ProyectoDAO> daos);

    @InheritInverseConfiguration
    @Mapping(target = "portafolio", ignore = true)
    ProyectoDAO toProyectoDao(Proyecto dao);



}
