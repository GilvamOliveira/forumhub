package com.example.forumhub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao;

    private String status;

    private String autor;

    private String curso;

    public Topico(){}

    public Topico(String titulo, String mensagem, String autor, String curso){
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
        this.dataCriacao = LocalDateTime.now();
        this.status = "ABERTO";
    }

    public Long getId(){ return id; }

    public String getTitulo(){ return titulo; }

    public String getMensagem(){ return mensagem; }

    public String getAutor(){ return autor; }

    public String getCurso(){ return curso; }

    public String getStatus(){ return status; }

    public LocalDateTime getDataCriacao(){ return dataCriacao; }

    public void atualizar(String titulo,String mensagem,String curso){
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.curso = curso;
    }

}