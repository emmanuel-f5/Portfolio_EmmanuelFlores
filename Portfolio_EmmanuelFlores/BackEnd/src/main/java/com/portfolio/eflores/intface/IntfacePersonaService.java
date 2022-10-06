package com.portfolio.eflores.intface;

import com.portfolio.eflores.entity.Persona;
import java.util.List;

public interface IntfacePersonaService {
    public List<Persona> getPersona();
    public void savePersona(Persona persona);
    public void deletePersona(Long id);
    public Persona findPersona(Long id);
}
