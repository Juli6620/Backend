/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolioMJP.mjp.Service;

import com.portfolioMJP.mjp.Entity.Banner;
import com.portfolioMJP.mjp.Repository.RBanner;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SBanner {
     @Autowired
     RBanner rBanner;
     
     public List<Banner> list(){
         return rBanner.findAll();
     }
     
     public Optional<Banner> getOne(int id){
         return rBanner.findById(id);
     }
     
     public Optional<Banner> getByFotoB(String fotoB){
         return rBanner.findByFotoB(fotoB);
     }
     
     public void save(Banner ban){
         rBanner.save(ban);
     }
     
     public void delete(int id){
         rBanner.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rBanner.existsById(id);
     }
     
     public boolean existsByFotoB(String fotoB){
         return rBanner.existsByFotoB(fotoB);
     }
}