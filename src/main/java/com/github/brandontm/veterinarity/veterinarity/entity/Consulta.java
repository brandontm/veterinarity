package com.github.brandontm.veterinarity.veterinarity.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Consulta {
    private Integer id;
    private Integer idPaciente;
    private Integer idExamenFisico;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecConsulta;
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

    public LocalDate getFecConsulta() {
        return fecConsulta;
    }

    public void setFecConsulta(LocalDate fecConsulta) {
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
