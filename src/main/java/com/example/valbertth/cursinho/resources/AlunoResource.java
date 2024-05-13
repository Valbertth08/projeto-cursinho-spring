package com.example.valbertth.cursinho.resources;


import com.example.valbertth.cursinho.entites.Aluno;
import com.example.valbertth.cursinho.repositories.AlunoRepository;
import com.example.valbertth.cursinho.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {
    @Autowired
    AlunoService alunoService;
    @GetMapping
    public ResponseEntity<List<Aluno>> fingAll(){
        List<Aluno> alunos= alunoService.findAll();
        return ResponseEntity.ok().body(alunos);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Aluno> findById(@PathVariable Integer id){
         Aluno aluno= alunoService.findById(id);
         return  ResponseEntity.ok().body(aluno);
    }
   @PostMapping
    public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno){
        aluno=alunoService.insert(aluno);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(aluno);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Integer id,@RequestBody Aluno aluno){
       aluno= alunoService.update(id,aluno);
       return ResponseEntity.ok().body(aluno);
    }


}
