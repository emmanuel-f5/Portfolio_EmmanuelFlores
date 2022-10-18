package com.portfolio.eflores.service;

import com.portfolio.eflores.entity.Experiencia;
import com.portfolio.eflores.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    ExperienciaRepository experienciaRepository;
    
    public List<Experiencia> list() {
        return experienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id) {
        return experienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp) {
        return experienciaRepository.findByNombreExp(nombreExp);
    }
    
    public void save(Experiencia exp) {
        experienciaRepository.save(exp);
    }
    
    public void delete(int id) {
        experienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return experienciaRepository.existsById(id);
    }
    
    public boolean existByNombreExp(String nombreExp) {
        return experienciaRepository.existsByNombreExp(nombreExp);
    }
}
