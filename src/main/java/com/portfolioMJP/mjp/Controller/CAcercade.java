/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolioMJP.mjp.Controller;



import com.portfolioMJP.mjp.Dto.dtoAcercade;
import com.portfolioMJP.mjp.Entity.Acercade;
import com.portfolioMJP.mjp.Security.Controller.Mensaje;
import com.portfolioMJP.mjp.Service.SAcercade;
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
@RequestMapping("/acercade/")
@CrossOrigin(origins = "https://portfoliomjp-40113.web.app/acercade/")
public class CAcercade {
    @Autowired
    SAcercade sAcercade;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Acercade>> list(){
        List<Acercade> list = sAcercade.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Acercade> getById(@PathVariable("id")int id){
        if(!sAcercade.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Acercade acercade = sAcercade.getOne(id).get();
        return new ResponseEntity(acercade, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sAcercade.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sAcercade.delete(id);
        return new ResponseEntity(new Mensaje("Información eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercade dtoacercade){
        if(StringUtils.isBlank(dtoacercade.getNombreA())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sAcercade.existsByNombreA(dtoacercade.getNombreA())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Acercade acercade = new Acercade(
                dtoacercade.getNombreA(), dtoacercade.getDescripcionA(), dtoacercade.getTituloA(), dtoacercade.getFotoA() 
        );
        sAcercade.save(acercade);
        return new ResponseEntity(new Mensaje("Información creada"), HttpStatus.OK);
                
    
   }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercade dtoacerca){
        //Validamos si existe el ID
        if(!sAcercade.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sAcercade.existsByNombreA(dtoacerca.getNombreA()) && sAcercade.getByNombreA(dtoacerca.getNombreA()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa nombre ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoacerca.getNombreA()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Acercade acercade = sAcercade.getOne(id).get();
        acercade.setNombreA(dtoacerca.getNombreA());
        acercade.setDescripcionA((dtoacerca.getDescripcionA()));
        acercade.setTituloA((dtoacerca.getTituloA()));
        acercade.setFotoA((dtoacerca.getFotoA()));
        
        sAcercade.save(acercade);
        return new ResponseEntity(new Mensaje("Información actualizada"), HttpStatus.OK);
    }

}