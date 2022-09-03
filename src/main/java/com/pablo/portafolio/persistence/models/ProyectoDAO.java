package com.pablo.portafolio.persistence.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="proyecto")
public class ProyectoDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProyecto;
    @Column(nullable = false)
    private String nombreEmpresa;
    @Column(nullable = false)
    private String cargo;
    @Column(nullable = false)
    private String nombreProyecto;
    @Column(nullable = false)
    private String ciudad;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String tecnologia;

    @Column(nullable = false)
    private int idPortafolio;

    @Column(nullable = false)
    private Date fecha_inicio;
    @Column(nullable = true)
    private Date fecha_termino;

    @ManyToOne
    @JoinColumn(name="idPortafolio", insertable = false, updatable = false)
    @JsonIgnore
    private PortafolioDAO portafolio;

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public int getIdPortafolio() {
        return idPortafolio;
    }

    public void setIdPortafolio(int idPortafolio) {
        this.idPortafolio = idPortafolio;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public PortafolioDAO getPortafolio() {
        return portafolio;
    }

    public void setPortafolio(PortafolioDAO portafolio) {
        this.portafolio = portafolio;
    }
}
