package com.example.valbertth.cursinho.resources;


import com.example.valbertth.cursinho.entites.Disciplina;
import com.example.valbertth.cursinho.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {
    @Autowired
    DisciplinaService disciplinaService;
    @GetMapping
    public ResponseEntity<List<Disciplina>> findAll(){
        List<Disciplina> lista= disciplinaService.findAll();
        return ResponseEntity.ok().body(lista);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable  Integer id){
            Disciplina dc= disciplinaService.findById(id);
            return  ResponseEntity.ok().body(dc);
    }

}
