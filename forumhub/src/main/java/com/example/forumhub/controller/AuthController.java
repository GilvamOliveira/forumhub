package com.example.forumhub.controller;

import com.example.forumhub.dto.DadosLogin;
import com.example.forumhub.security.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String login(@RequestBody DadosLogin dados){

        return tokenService.gerarToken(dados.login());

    }

}