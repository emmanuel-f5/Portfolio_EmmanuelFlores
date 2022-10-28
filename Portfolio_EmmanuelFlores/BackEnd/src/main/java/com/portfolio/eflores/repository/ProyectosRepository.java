package com.portfolio.eflores.repository;

import com.portfolio.eflores.entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos, Integer> {
    public Optional<Proyectos> findByNombreProy(String nombreProy);
    public boolean existsByNombreProy(String nombreProy);
}
