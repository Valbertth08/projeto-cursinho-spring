package com.example.valbertth.cursinho.config;


import com.example.valbertth.cursinho.entites.*;
import com.example.valbertth.cursinho.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {//essa clase é executada quando é inicado a aplicação
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    MatriculaRepository matriculaRepository;
    @Override
    public void run(String... args) throws Exception {

        Turma turma= new Turma(null,"200");
        Turma turma2= new Turma(null,"300");
        turmaRepository.saveAll(Arrays.asList(turma,turma2));

        Aluno aluno1= new Aluno(null,"Pedro",12,00000000,"email",88737);
        Aluno aluno2= new Aluno(null,"Carlos",12,00000000,"email",88737);
        alunoRepository.saveAll(Arrays.asList(aluno1,aluno2));

        Professor professor1= new Professor(null,"Jose","jose@gmail.com");
        Professor professor2= new Professor(null,"gabriel","gabriel@gmail.com");

        Disciplina disciplina1= new Disciplina(null,"matematica");
        Disciplina disciplina2= new Disciplina(null,"Portugeus");
        Disciplina disciplina3= new Disciplina(null,"Historia");

        professor1.getTurmas().add(turma);
        professor1.getTurmas().add(turma2);
        professor2.getTurmas().add(turma);

        disciplina2.getProfessores().add(professor1);
        disciplina2.getProfessores().add(professor2);
        disciplina1.getProfessores().add(professor1);
        professorRepository.saveAll(Arrays.asList(professor1,professor2));
        disciplinaRepository.saveAll(Arrays.asList(disciplina1,disciplina2,disciplina3));

        Matricula matricula1= new Matricula(aluno1,turma, Instant.parse("2019-06-20T19:53:07Z"),"7");
        Matricula matricul2= new Matricula(aluno1,turma2, Instant.parse("2019-06-20T19:53:07Z"),"8");
        matriculaRepository.saveAll(Arrays.asList(matricula1,matricul2));









    }
}
