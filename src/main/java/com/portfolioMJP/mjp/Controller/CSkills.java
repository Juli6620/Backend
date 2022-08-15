/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolioMJP.mjp.Controller;

import com.portfolioMJP.mjp.Dto.dtoSkills;
import com.portfolioMJP.mjp.Entity.Skills;
import com.portfolioMJP.mjp.Security.Controller.Mensaje;
import com.portfolioMJP.mjp.Service.SSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill/")
@CrossOrigin(origins = "https://portfoliomjp-40113.web.app/skill/")
public class CSkills {
    @Autowired
    SSkills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skill = sSkills.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skills eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){      
        if(StringUtils.isBlank(dtoskills.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sSkills.existsByNombreS(dtoskills.getNombreS()))
            return new ResponseEntity(new Mensaje("Esa skills existe"), HttpStatus.BAD_REQUEST);
        
        Skills skill = new Skills(dtoskills.getNombreS(), dtoskills.getDescripcionS());
        sSkills.save(skill);
        
        return new ResponseEntity(new Mensaje("Skills agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
        //Validamos si existe el ID
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sSkills.existsByNombreS(dtoskills.getNombreS()) && sSkills.getByNombreS(dtoskills.getNombreS()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa skills ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoskills.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skills skill = sSkills.getOne(id).get();
        skill.setNombreS(dtoskills.getNombreS());
        skill.setDescripcionS((dtoskills.getDescripcionS()));
        
        sSkills.save(skill);
        return new ResponseEntity(new Mensaje("Skills actualizada"), HttpStatus.OK);
             
    }
}