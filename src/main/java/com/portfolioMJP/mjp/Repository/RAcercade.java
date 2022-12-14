/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolioMJP.mjp.Repository;

import com.portfolioMJP.mjp.Entity.Acercade;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RAcercade extends JpaRepository<Acercade, Integer>{
    public Optional<Acercade> findByNombreA(String nombreA);
    public boolean existsByNombreA(String nombreA);
}