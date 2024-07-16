package com.example.demo.controller;


import domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topicos")
@SecurityRequirement (name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepositorio repositorio;

    //Adicionar topico no BD
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico (@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(dados);
        repositorio.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    //listar os tópicos
    @GetMapping
    public ResponseEntity listarTopico () {
        List<DadosListarMedicos> dadosListados = repositorio.finfAllByEstadoDoTopicoTrue();
        return ResponseEntity.ok(dadosListados);
    }

    //listar um tópico por id
    @GetMapping ("/{id}")
    public ResponseEntity detalharTopicos (@PathVariable Long id) {
        var topico = repositorio.getReferenceById(id);
        return  ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopico (@RequestBody @Valid DadosAtualizaTopico dados) {
        var topico = repositorio.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(dados);

    }

    @DeleteMapping ("/{id}")
    @Transactional
    public ResponseEntity excluirTopico (@PathVariable Long id) {
        var topico = repositorio.getReferenceById(id);
        topico.excluirTopico();

        return ResponseEntity.noContent().build();
    }
}

