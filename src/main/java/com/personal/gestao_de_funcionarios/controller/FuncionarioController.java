package com.personal.gestao_de_funcionarios.controller;

import com.personal.gestao_de_funcionarios.model.Funcionario;
import com.personal.gestao_de_funcionarios.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
@Transactional
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController (FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Funcionario> getById(@PathVariable Long id){
        var funcionario = funcionarioService.findById(id);
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAll(){
        var funcionarios = funcionarioService.listaTodos();
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario){
        var funcCriado = funcionarioService.create(funcionario);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(funcCriado.getFuncionario_id())
                .toUri();
        return ResponseEntity.created(location).body(funcCriado);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario funcionario, @PathVariable String email){
        var funcUpdated = funcionarioService.update(funcionario, email);
        return ResponseEntity.ok(funcUpdated);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> delete(@PathVariable String email){
        funcionarioService.delete(email);
        return  ResponseEntity.noContent().build();
    }


}
