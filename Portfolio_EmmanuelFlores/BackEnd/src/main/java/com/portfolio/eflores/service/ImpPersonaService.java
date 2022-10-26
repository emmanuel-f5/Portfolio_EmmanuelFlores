package com.portfolio.eflores.service;

import com.portfolio.eflores.entity.Persona;
import com.portfolio.eflores.repository.IntfacePersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService {

    @Autowired
    IntfacePersonaRepository intfacePersonaRepository;

    public List<Persona> list() {
        return intfacePersonaRepository.findAll();
    }

    public Optional<Persona> getOne(int id) {
        return intfacePersonaRepository.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return intfacePersonaRepository.findByNombre(nombre);
    }

    public void save(Persona persona) {
        intfacePersonaRepository.save(persona);
    }

    public void delete(int id) {
        intfacePersonaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return intfacePersonaRepository.existsById(id);
    }

    public boolean existByNombre(String nombre) {
        return intfacePersonaRepository.existsByNombre(nombre);
    }

}
