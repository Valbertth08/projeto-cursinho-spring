package com.example.valbertth.cursinho.repositories;

import com.example.valbertth.cursinho.entites.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository  extends JpaRepository<Aluno,Integer> {
}
