package com.pablo.portafolio.persistence.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="portafolio")
public class PortafolioDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idPortafolio;

    @Column(name = "aliasportafolio", nullable = false)
    private String aliasPortafolio;


    @OneToMany(mappedBy = "portafolio")
    @JsonIgnore
    @ToString.Exclude
    private List<InstitucionDAO> educacion;


    @OneToMany(mappedBy = "portafolio")
    @JsonIgnore
    @ToString.Exclude
    private List<ProyectoDAO> experiencia;


    @Column(nullable = false, unique = true)
    private long rut;

    @OneToOne
    @JoinColumn(name="rut", insertable = false, updatable = false)
    private UsuarioDAO usuario;

    public int getIdPortafolio() {
        return idPortafolio;
    }

    public void setIdPortafolio(int idPortafolio) {
        this.idPortafolio = idPortafolio;
    }

    public String getAliasPortafolio() {
        return aliasPortafolio;
    }

    public void setAliasPortafolio(String aliasPortafolio) {
        this.aliasPortafolio = aliasPortafolio;
    }

    public List<InstitucionDAO> getEducacion() {
        return educacion;
    }

    public void setEducacion(List<InstitucionDAO> educacion) {
        this.educacion = educacion;
    }

    public List<ProyectoDAO> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(List<ProyectoDAO> experiencia) {
        this.experiencia = experiencia;
    }

    public long getRut() {
        return rut;
    }

    public void setRut(long rut) {
        this.rut = rut;
    }

    public UsuarioDAO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDAO usuario) {
        this.usuario = usuario;
    }
}
