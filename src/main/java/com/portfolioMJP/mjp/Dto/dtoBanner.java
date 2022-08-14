/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolioMJP.mjp.Dto;

import javax.validation.constraints.NotBlank;

public class dtoBanner {
    @NotBlank
    private String fotoB;

    public dtoBanner() {
    }

    public dtoBanner(String fotoB) {
        this.fotoB = fotoB;
    }

    public String getFotoB() {
        return fotoB;
    }

    public void setFotoB(String fotoB) {
        this.fotoB = fotoB;
    }
    
}