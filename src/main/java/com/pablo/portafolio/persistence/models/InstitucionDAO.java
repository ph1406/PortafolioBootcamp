package com.pablo.portafolio.persistence.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;

@Entity
@Table(name="institucion")
public class InstitucionDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInstitucion;

    @Column(nullable = false)
    private String nombreInstitucion;

    @Column(nullable = false)
    private String nombreTitulo;
    @Column(nullable = false)
    private String tipoInstitucion;
    @Positive
    @Column(nullable = false)
    private int anio_inicio;
    @Positive
    @Column(nullable = true)
    private int anio_termino;

    @Min(1)
    @Positive
    @Column(nullable = false)
    private int idPortafolio;

    @ManyToOne
    @JoinColumn(name="idPortafolio", insertable = false, updatable = false)
    @JsonIgnore
    @ToString.Exclude
    private PortafolioDAO portafolio;

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getNombreTitulo() {
        return nombreTitulo;
    }

    public void setNombreTitulo(String nombreTitulo) {
        this.nombreTitulo = nombreTitulo;
    }

    public String getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(String tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public int getAnio_inicio() {
        return anio_inicio;
    }

    public void setAnio_inicio(int anio_inicio) {
        this.anio_inicio = anio_inicio;
    }

    public int getAnio_termino() {
        return anio_termino;
    }

    public void setAnio_termino(int anio_termino) {
        this.anio_termino = anio_termino;
    }

    public int getIdPortafolio() {
        return idPortafolio;
    }

    public void setIdPortafolio(int idPortafolio) {
        this.idPortafolio = idPortafolio;
    }

    public PortafolioDAO getPortafolio() {
        return portafolio;
    }

    public void setPortafolio(PortafolioDAO portafolio) {
        this.portafolio = portafolio;
    }
}
