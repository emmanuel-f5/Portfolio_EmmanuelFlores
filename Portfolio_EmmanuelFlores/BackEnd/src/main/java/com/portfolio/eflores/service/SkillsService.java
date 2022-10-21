package com.portfolio.eflores.service;

import com.portfolio.eflores.entity.Skills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.eflores.repository.SkillsRepository;

@Transactional
@Service
public class SkillsService {
    @Autowired
    SkillsRepository skillsRepository;
    
    public List<Skills> list(){
        return skillsRepository.findAll();
    }
    
    public Optional<Skills> getOne(int id){
        return skillsRepository.findById(id);
    }
    
    public Optional<Skills> getByNombreS(String nombreS){
        return skillsRepository.findByNombreS(nombreS);
    }
    
    public void save(Skills skills){
        skillsRepository.save(skills);
    }
    
    public void delete(int id){
        skillsRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return skillsRepository.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS){
        return skillsRepository.existsByNombreS(nombreS);
    }
}
