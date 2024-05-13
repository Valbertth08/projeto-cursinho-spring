package com.example.valbertth.cursinho.resources;

import com.example.valbertth.cursinho.entites.Professor;
import com.example.valbertth.cursinho.entites.Turma;
import com.example.valbertth.cursinho.service.ProfessorService;
import com.example.valbertth.cursinho.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {
    @Autowired
    ProfessorService professorService;
    @GetMapping
    public ResponseEntity<List<Professor>> findAll(){
        List<Professor> professores= professorService.findAll();
        return ResponseEntity.ok().body(professores);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Integer id){
        Professor professor= professorService.findById(id);
        return ResponseEntity.ok().body(professor);
    }




}
