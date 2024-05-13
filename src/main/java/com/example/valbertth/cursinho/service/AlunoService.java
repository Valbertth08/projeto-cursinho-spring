package com.example.valbertth.cursinho.service;


import com.example.valbertth.cursinho.entites.Aluno;
import com.example.valbertth.cursinho.repositories.AlunoRepository;
import com.example.valbertth.cursinho.service.exceptions.DataBaseException;
import com.example.valbertth.cursinho.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;
    public List<Aluno> findAll(){

        return alunoRepository.findAll();
    }
    public Aluno findById(Integer id){
        Optional<Aluno> aluno= alunoRepository.findById(id);
        return aluno.orElseThrow(()->new ResourceNotFoundException(id));
    }

    public Aluno insert(Aluno obj){
        return alunoRepository.save(obj);
    }
    public void delete(Integer id){
        try{
            alunoRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw  new DataBaseException(e.getMessage());
        }

    }

    public Aluno update(Integer id, Aluno aluno){
        try {
        Aluno entity = alunoRepository.getReferenceById(id);
        updateData(entity,aluno);
        return alunoRepository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public Aluno updateData(Aluno entity, Aluno aluno){
        entity.setNome(aluno.getNome());
        entity.setCpf(aluno.getCpf());
        entity.setEmail(aluno.getEmail());
        entity.setTelefone(aluno.getIdade());
        return entity;
    }
}
