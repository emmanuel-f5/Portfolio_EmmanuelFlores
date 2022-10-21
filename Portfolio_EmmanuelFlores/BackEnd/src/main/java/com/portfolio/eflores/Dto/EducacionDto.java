package com.portfolio.eflores.Dto;

import javax.validation.constraints.NotBlank;

public class EducacionDto{
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descripcionEdu;

    public EducacionDto(){
    }

    public EducacionDto(String nombreEdu, String descripcionEdu){
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
    }

    public String getNombreEdu(){
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu){
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu(){
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu){
        this.descripcionEdu = descripcionEdu;
    }
    
    
}
