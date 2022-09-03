package com.pablo.portafolio.domain.entity;

import javax.sound.sampled.Port;
import java.util.List;

public class Portafolio {

    private int idPortafolio;
    private String aliasPortafolio;
    private long rut;
    private Usuario usuario;
    private List<Institucion> educacion;
    private  List<Proyecto> experiencia;

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

    public long getRut() {
        return rut;
    }

    public void setRut(long rut) {
        this.rut = rut;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Institucion> getEducacion() {
        return educacion;
    }

    public void setEducacion(List<Institucion> educacion) {
        this.educacion = educacion;
    }

    public List<Proyecto> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(List<Proyecto> experiencia) {
        this.experiencia = experiencia;
    }
}
