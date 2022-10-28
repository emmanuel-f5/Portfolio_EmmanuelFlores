package com.portfolio.eflores.controller;

import com.portfolio.eflores.Dto.ProyectosDto;
import com.portfolio.eflores.entity.Proyectos;
import com.portfolio.eflores.security.controller.Mensaje;
import com.portfolio.eflores.service.ProyectosService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proy")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontendeflores.web.app")
public class ControllerProyectos {
    @Autowired
    ProyectosService proyectosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectosDto proydto) {
        if(StringUtils.isBlank(proydto.getNombreProy())) {
            return new ResponseEntity(new Mensaje("Debe ingresar un nombre"), HttpStatus.BAD_REQUEST);
        }
        if(proyectosService.existByNombreProy(proydto.getNombreProy())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = new Proyectos(proydto.getNombreProy(), proydto.getDescripcionProy());
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectosDto proydto) {
        if(!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(proyectosService.existByNombreProy(proydto.getNombreProy()) && proyectosService.getByNombreProy(proydto.getNombreProy()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(proydto.getNombreProy())) {
            return new ResponseEntity(new Mensaje("Debe ingresar un nombre"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setNombreProy(proydto.getNombreProy());
        proyectos.setDescripcionProy(proydto.getDescripcionProy());
        
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
}
