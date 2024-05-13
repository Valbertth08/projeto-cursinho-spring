package com.example.valbertth.cursinho.repositories;

import com.example.valbertth.cursinho.entites.Professor;
import com.example.valbertth.cursinho.entites.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Integer> {


}
