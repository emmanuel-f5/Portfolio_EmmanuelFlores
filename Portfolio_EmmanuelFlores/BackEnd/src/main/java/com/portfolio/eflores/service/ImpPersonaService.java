package com.portfolio.eflores.service;

import com.portfolio.eflores.entity.Persona;
import com.portfolio.eflores.intface.IntfacePersonaService;
import com.portfolio.eflores.repository.IntfacePersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IntfacePersonaService{
    @Autowired IntfacePersonaRepository intfacePersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = intfacePersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        intfacePersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        intfacePersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = intfacePersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
