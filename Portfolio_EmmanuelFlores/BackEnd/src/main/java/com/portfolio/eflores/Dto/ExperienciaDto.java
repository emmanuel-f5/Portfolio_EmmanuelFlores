package com.portfolio.eflores.Dto;

import javax.validation.constraints.NotBlank;


public class ExperienciaDto {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String descripcionExp;
    
    //Constructores

    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombreExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
    }
    
    //Getters y Setters

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }
    
    
}
