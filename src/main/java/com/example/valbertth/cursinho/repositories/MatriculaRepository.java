package com.example.valbertth.cursinho.repositories;

import com.example.valbertth.cursinho.entites.Matricula;
import com.example.valbertth.cursinho.entites.Turma;
import com.example.valbertth.cursinho.entites.pk.AlunoTurmaPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, AlunoTurmaPk> {

}
