package com.github.brandontm.veterinarity.veterinarity.entity;

public class Domicilio {
  private Integer id;
  private String colonia;
  private String calle;
  private short numeroCasa;

  public Integer getId() {
    return id;
  }

  public short getNumeroCasa() {
    return numeroCasa;
  }

  public void setNumeroCasa(short numeroCasa) {
    this.numeroCasa = numeroCasa;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public String getColonia() {
    return colonia;
  }

  public void setColonia(String colonia) {
    this.colonia = colonia;
  }

  public void setId(Integer id) {
    this.id = id;
  }


    // other fields, getters and setters
}