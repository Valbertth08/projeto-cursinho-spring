package com.example.valbertth.cursinho.entites.pk;

import com.example.valbertth.cursinho.entites.Aluno;
import com.example.valbertth.cursinho.entites.Turma;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


@Embeddable
public class AlunoTurmaPk implements Serializable {
    private static final long serialVersionUID=1L;


    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoTurmaPk that = (AlunoTurmaPk) o;
        return Objects.equals(aluno, that.aluno) && Objects.equals(turma, that.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aluno, turma);
    }
}
