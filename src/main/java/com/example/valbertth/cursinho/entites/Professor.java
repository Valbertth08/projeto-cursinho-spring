package com.example.valbertth.cursinho.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_professor")
public class Professor implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String email;
    public Professor() {
    }
    @ManyToMany
    @JoinTable( name = "tb_TurmaProfessor", joinColumns = @JoinColumn(name = "id_professor"),inverseJoinColumns = @JoinColumn(name = "id_turma"))
    private List<Turma> turmas= new ArrayList<>();

    @ManyToMany(mappedBy = "professores")
    private List<Disciplina> disciplinas= new ArrayList<>();

    public Professor(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
