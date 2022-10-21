package com.portfolio.eflores.repository;

import com.portfolio.eflores.entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills, Integer>{
    Optional<Skills> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}
