package com.portfolio.eflores.Dto;

import javax.validation.constraints.NotBlank;

public class PersonaDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    private String titulo;
    private String descripcionPers;
    private String img;
    
    //Constructores

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String titulo, String descripcionPers, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcionPers = descripcionPers;
        this.img = img;
    }
    
    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
        
    public String getDescripcionPers() {
        return descripcionPers;
    }

    public void setDescripcionPers(String descripcionPers) {
        this.descripcionPers = descripcionPers;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
