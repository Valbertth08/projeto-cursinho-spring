package com.example.valbertth.cursinho.service;

import com.example.valbertth.cursinho.entites.Turma;
import com.example.valbertth.cursinho.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public List<Turma> findAll(){
        return turmaRepository.findAll();
    }
    public  Turma findById(Integer id){
        Optional<Turma> turma= turmaRepository.findById(id);
        return  turma.get();
    }
}
