package com.example.valbertth.cursinho.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_turma")
public class Turma  implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String sala;

    @ManyToMany(mappedBy = "turmas")
    List<Professor> professores=new ArrayList<>();

    @OneToMany(mappedBy = "id.turma")
    Set<Matricula> matriculas= new HashSet<>();
    public Turma() {
    }
    public Turma(Integer id, String sala) {
        this.id = id;
        this.sala = sala;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }


    @JsonIgnore
    public List<Professor> getProfessores() {
        return professores;
    }


    @JsonIgnore
    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(id, turma.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
