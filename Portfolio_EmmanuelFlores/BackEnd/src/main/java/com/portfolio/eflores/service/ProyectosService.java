package com.portfolio.eflores.service;

import com.portfolio.eflores.entity.Proyectos;
import com.portfolio.eflores.repository.ProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService {
    @Autowired
    ProyectosRepository proyectosRepository;
    
    public List<Proyectos> list() {
        return proyectosRepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id) {
        return proyectosRepository.findById(id);
    }
    
    public Optional<Proyectos> getByNombreProy(String nombreProy) {
        return proyectosRepository.findByNombreProy(nombreProy);
    }
    
    public void save(Proyectos proy) {
        proyectosRepository.save(proy);
    }
    
    public void delete(int id) {
        proyectosRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return proyectosRepository.existsById(id);
    }
    
    public boolean existByNombreProy(String nombreProy) {
        return proyectosRepository.existsByNombreProy(nombreProy);
    }
}
