package com.example.valbertth.cursinho.resources;

import com.example.valbertth.cursinho.entites.Turma;
import com.example.valbertth.cursinho.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaResource {
    @Autowired
    TurmaService turmaService;
    @GetMapping
    public ResponseEntity<List<Turma>> findAll(){
        List<Turma> turmas= turmaService.findAll();
        return ResponseEntity.ok().body(turmas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Integer id){
        Turma turma= turmaService.findById(id);
        return ResponseEntity.ok().body(turma);
    }




}
