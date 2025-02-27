package com.personal.gestao_de_funcionarios.controller;

import com.personal.gestao_de_funcionarios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController (FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }


}
