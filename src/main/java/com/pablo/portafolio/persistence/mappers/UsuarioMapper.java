package com.pablo.portafolio.persistence.mappers;

import com.pablo.portafolio.domain.entity.Usuario;
import com.pablo.portafolio.persistence.models.UsuarioDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {


    @Mappings({
            @Mapping(source = "rut", target = "rut"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellido_paterno", target = "apellido_paterno"),
            @Mapping(source = "apellido_materno", target = "apellido_materno"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "movil", target = "movil"),
            @Mapping(source = "repositorio", target = "repositorio"),
            @Mapping(source = "edad", target = "edad"),
            @Mapping(source = "fecha_nacimiento", target = "fecha_nacimiento"),
            @Mapping(source = "ciudad", target = "ciudad"),
            @Mapping(source = "pais", target = "pais"),
            @Mapping(source = "disponible", target = "disponible"),
            @Mapping(source = "disponibleExtranjero", target = "disponibleExtranjero")
    })
    Usuario toUsuario(UsuarioDAO dao);

    List<Usuario> toUsuarios(List<UsuarioDAO> daos);


    @InheritInverseConfiguration
    @Mapping(target = "portafolios", ignore = true)
    UsuarioDAO toUsuarioDao(Usuario dao);

}
