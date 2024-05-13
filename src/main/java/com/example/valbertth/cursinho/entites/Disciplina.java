package com.example.valbertth.cursinho.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina  implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    @ManyToMany
    @JoinTable(name = "tb_ProfDisciplina", joinColumns = @JoinColumn(name = "id_disciplina"),inverseJoinColumns = @JoinColumn(name = "id_professor"))
    private List<Professor> professores= new ArrayList<>();


    public Disciplina() {
    }

    public Disciplina(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @JsonIgnore
    public List<Professor> getProfessores() {
        return professores;
    }
}
