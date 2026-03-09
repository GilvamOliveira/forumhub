package com.example.forumhub.controller;

import com.example.forumhub.dto.*;
import com.example.forumhub.model.Topico;
import com.example.forumhub.repository.TopicoRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados){

        if(repository.existsByTituloAndMensagem(dados.titulo(),dados.mensagem())){
            throw new RuntimeException("Topico duplicado");
        }

        Topico topico = new Topico(
                dados.titulo(),
                dados.mensagem(),
                dados.autor(),
                dados.curso()
        );

        repository.save(topico);
    }

    @GetMapping
    public List<DadosListagemTopico> listar(){

        return repository.findAll()
                .stream()
                .map(DadosListagemTopico::new)
                .toList();

    }

    @GetMapping("/{id}")
    public DadosListagemTopico detalhar(@PathVariable Long id){

        Topico topico = repository.findById(id)
                .orElseThrow();

        return new DadosListagemTopico(topico);

    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id,
                          @RequestBody DadosAtualizacaoTopico dados){

        Topico topico = repository.findById(id).orElseThrow();

        topico.atualizar(
                dados.titulo(),
                dados.mensagem(),
                dados.curso()
        );

    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){

        repository.deleteById(id);

    }

}