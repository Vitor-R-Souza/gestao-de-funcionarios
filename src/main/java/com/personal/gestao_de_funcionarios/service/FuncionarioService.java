package com.personal.gestao_de_funcionarios.service;


import com.personal.gestao_de_funcionarios.model.Funcionario;
import com.personal.gestao_de_funcionarios.repository.FuncionarioRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario findById(Long id){
        return funcionarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Funcionario> listaTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario create(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario update(Funcionario funcionarioToUpdate, String email){
        Funcionario dbFuncionario = funcionarioRepository.findByEmail(email);
        if (!dbFuncionario.getNome().equals(funcionarioToUpdate.getNome())){
            throw new NoSuchElementException();
        }
        dbFuncionario.setNome(funcionarioToUpdate.getNome());
        dbFuncionario.setCargo(funcionarioToUpdate.getCargo());
        dbFuncionario.setDepartamento(funcionarioToUpdate.getDepartamento());
        dbFuncionario.setEmail(funcionarioToUpdate.getEmail());
        dbFuncionario.setEnderecoList(funcionarioToUpdate.getEnderecoList());
        dbFuncionario.setIdade(funcionarioToUpdate.getIdade());
        dbFuncionario.setTelefones(funcionarioToUpdate.getTelefones());

        return funcionarioRepository.save(dbFuncionario);
    }

    public void delete(String email){
        Funcionario dbFuncionario = funcionarioRepository.findByEmail(email);
        funcionarioRepository.delete(dbFuncionario);
    }

}
