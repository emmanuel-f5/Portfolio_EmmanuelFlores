package com.portfolio.eflores.controller;

import com.portfolio.eflores.Dto.SkillsDto;
import com.portfolio.eflores.entity.Skills;
import com.portfolio.eflores.security.controller.Mensaje;
import com.portfolio.eflores.service.SkillsService;
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
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontendeflores.web.app")
@RequestMapping("/skills")
public class ControllerSkills {

    @Autowired
    SkillsService skillsService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        Skills skills = skillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        skillsService.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillsDto skillsDto) {
        if (StringUtils.isBlank(skillsDto.getNombreS())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        if (skillsService.existsByNombreS(skillsDto.getNombreS())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skills hYs = new Skills(skillsDto.getNombreS(), skillsDto.getPorcentaje());
        skillsService.save(hYs);

        return new ResponseEntity(new Mensaje("Registro creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillsDto skillsDto) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        if (skillsService.existsByNombreS(skillsDto.getNombreS()) && skillsService.getByNombreS(skillsDto.getNombreS()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(skillsDto.getNombreS())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = skillsService.getOne(id).get();
        skills.setNombreS(skillsDto.getNombreS());
        skills.setPorcentaje(skillsDto.getPorcentaje());

        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Registro actualizado"), HttpStatus.OK);

    }
}
