package com.github.brandontm.veterinarity.veterinarity.entity;

import java.util.Date;

public class Consulta {
    private Integer id;
    private Integer idPaciente;
    private Integer idExamenFisico;
    private Date fecConsulta;
    private String observaciones;
    private String diagnostico;

    public Integer getId() {
        return id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecConsulta() {
        return fecConsulta;
    }

    public void setFecConsulta(Date fecConsulta) {
        this.fecConsulta = fecConsulta;
    }

    public Integer getIdExamenFisico() {
        return idExamenFisico;
    }

    public void setIdExamenFisico(Integer idExamenFisico) {
        this.idExamenFisico = idExamenFisico;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    // other fields, getters and setters
}
