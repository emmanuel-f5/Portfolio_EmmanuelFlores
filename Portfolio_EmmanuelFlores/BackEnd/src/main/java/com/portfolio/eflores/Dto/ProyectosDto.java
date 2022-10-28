package com.portfolio.eflores.Dto;

import javax.validation.constraints.NotBlank;


public class ProyectosDto {
    @NotBlank
    private String nombreProy;
    @NotBlank
    private String descripcionProy;
    
    //Constructores

    public ProyectosDto() {
    }

    public ProyectosDto(String nombreProy, String descripcionProy) {
        this.nombreProy = nombreProy;
        this.descripcionProy = descripcionProy;
    }
    
    //Getters y Setters

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public String getDescripcionProy() {
        return descripcionProy;
    }

    public void setDescripcionProy(String descripcionProy) {
        this.descripcionProy = descripcionProy;
    }    
}
