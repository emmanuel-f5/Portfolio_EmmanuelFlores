package com.portfolio.eflores.controller;

import com.portfolio.eflores.Dto.PersonaDto;
import com.portfolio.eflores.entity.Persona;
import com.portfolio.eflores.security.controller.Mensaje;
import com.portfolio.eflores.service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontendeflores.web.app")
public class ControllerPersona {
    @Autowired
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado"), HttpStatus.OK);
    }*/
    
    /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){
        if(StringUtils.isBlank(personaDto.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        if(personaService.existByNombre(personaDto.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = new Persona(
                personaDto.getNombre(), personaDto.getDescripcionPers()
            );
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Registro creado"), HttpStatus.OK);
                
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonaDto personaDto){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existByNombre(personaDto.getNombre()) && personaService.getByNombre(personaDto.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(personaDto.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setTitulo(personaDto.getTitulo());
        persona.setDescripcionPers(personaDto.getDescripcionPers());
        persona.setImg(personaDto.getImg());
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Registro actualizado"), HttpStatus.OK);
    }
}
