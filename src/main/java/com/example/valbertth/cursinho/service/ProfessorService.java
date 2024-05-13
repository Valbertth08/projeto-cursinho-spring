package com.example.valbertth.cursinho.service;

import com.example.valbertth.cursinho.entites.Professor;
import com.example.valbertth.cursinho.entites.Turma;
import com.example.valbertth.cursinho.repositories.ProfessorRepository;
import com.example.valbertth.cursinho.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;
    public List<Professor> findAll(){
        return professorRepository.findAll();
    }
    public Professor findById(Integer id){
        Optional<Professor> professor= professorRepository.findById(id);
        return  professor.get();
    }

}
