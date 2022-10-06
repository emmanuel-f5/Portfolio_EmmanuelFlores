package com.portfolio.eflores.repository;

import com.portfolio.eflores.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntfacePersonaRepository extends JpaRepository<Persona, Long>{
    
}
