package com.example.valbertth.cursinho.entites;

import com.example.valbertth.cursinho.entites.pk.AlunoTurmaPk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_matricula")
public class Matricula implements Serializable {
    private static final long serialVersionUID=1L;
    @EmbeddedId
    private AlunoTurmaPk id= new AlunoTurmaPk();
    private Instant ano_letivo;

    private String semestre;

    public Matricula() {
    }
    public Matricula(Aluno aluno, Turma turma, Instant ano_letivo, String semestre) {
        this.ano_letivo = ano_letivo;
        this.semestre = semestre;
        id.setAluno(aluno);
        id.setTurma(turma);

    }

    public Instant getAno_letivo() {
        return ano_letivo;
    }

    public void setAno_letivo(Instant ano_letivo) {
        this.ano_letivo = ano_letivo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @JsonIgnore
    public Aluno getAluno(){

        return  id.getAluno();
    }
    public void setAluno(Aluno aluno){
          id.setAluno(aluno);
    }

   public Turma getTurma(){
        return  id.getTurma();
   }
   public void setTurma(Turma turma){
        id.setTurma(turma);
   }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return Objects.equals(id, matricula.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
