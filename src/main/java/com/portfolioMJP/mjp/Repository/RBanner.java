
package com.portfolioMJP.mjp.Repository;


import com.portfolioMJP.mjp.Entity.Banner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


 @Repository
public interface RBanner extends JpaRepository<Banner, Integer>{
    public Optional<Banner> findByFotoB(String fotoB);
    public boolean existsByFotoB(String fotoB);
}
    

