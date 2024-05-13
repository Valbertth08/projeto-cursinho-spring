package com.example.valbertth.cursinho.service;


import com.example.valbertth.cursinho.entites.Aluno;
import com.example.valbertth.cursinho.entites.Disciplina;
import com.example.valbertth.cursinho.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    DisciplinaRepository disciplinaRepository;

    public List<Disciplina> findAll(){
        return  disciplinaRepository.findAll();
    }

    public Disciplina findById( Integer id){
        Optional<Disciplina> aluno= disciplinaRepository.findById(id);
        return  aluno.get();
    }

}
