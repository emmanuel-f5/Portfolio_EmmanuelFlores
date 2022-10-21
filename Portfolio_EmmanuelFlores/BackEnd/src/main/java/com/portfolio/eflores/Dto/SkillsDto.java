package com.portfolio.eflores.Dto;

import javax.validation.constraints.NotBlank;


public class SkillsDto {
    @NotBlank
    private String nombreS;
    @NotBlank
    private int porcentaje;

    public SkillsDto() {
    }

    public SkillsDto(String nombreS, int porcentaje) {
        this.nombreS = nombreS;
        this.porcentaje = porcentaje;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
