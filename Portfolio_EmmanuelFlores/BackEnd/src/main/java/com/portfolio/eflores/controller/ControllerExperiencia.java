
package com.portfolio.eflores.controller;

import com.portfolio.eflores.Dto.ExperienciaDto;
import com.portfolio.eflores.entity.Experiencia;
import com.portfolio.eflores.security.controller.Mensaje;
import com.portfolio.eflores.service.ExperienciaService;
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
@RequestMapping("/explab")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontendeflores.web.app")
public class ControllerExperiencia {
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto expdto) {
        if(StringUtils.isBlank(expdto.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Debe ingresar un nombre"), HttpStatus.BAD_REQUEST);
        }
        if(experienciaService.existByNombreExp(expdto.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(expdto.getNombreExp(), expdto.getDescripcionExp());
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDto expdto) {
        if(!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(experienciaService.existByNombreExp(expdto.getNombreExp()) && experienciaService.getByNombreExp(expdto.getNombreExp()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(expdto.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Debe ingresar un nombre"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombreExp(expdto.getNombreExp());
        experiencia.setDescripcionExp(expdto.getDescripcionExp());
        
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
