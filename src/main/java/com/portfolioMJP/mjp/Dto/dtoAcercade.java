/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolioMJP.mjp.Dto;

import javax.validation.constraints.NotBlank;

public class dtoAcercade {
    @NotBlank
    private String nombreA;
    @NotBlank
    private String descripcionA;
    @NotBlank
    private String tituloA;
@NotBlank
    private String fotoA;
    
    
    public dtoAcercade() {
    }

    public dtoAcercade(String nombreA, String descripcionA, String tituloA, String fotoA) {
        this.nombreA = nombreA;
        this.descripcionA = descripcionA;
        this.tituloA = tituloA;
        this.fotoA = fotoA;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getDescripcionA() {
        return descripcionA;
    }

    public void setDescripcionA(String descripcionA) {
        this.descripcionA = descripcionA;
    }

    public String getTituloA() {
        return tituloA;
    }

    public void setTituloA(String tituloA) {
        this.tituloA = tituloA;
    }

    public String getFotoA() {
        return fotoA;
    }

    public void setFotoA(String fotoA) {
        this.fotoA = fotoA;
    }

}