package com.example.demo.controller;

import com.example.demo.infra.seguranca.DadosToken;
import com.example.demo.infra.seguranca.TokenService;
import domain.usuario.DadosAutencicacao;
import domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin (@RequestBody @Valid DadosAutencicacao dados){
        var autheticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication =  manager.authenticate(autheticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosToken(tokenJWT));

    }
}
