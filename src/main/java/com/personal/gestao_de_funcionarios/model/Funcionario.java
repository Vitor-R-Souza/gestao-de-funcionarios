package com.personal.gestao_de_funcionarios.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String departamento;

    private ArrayList<String> telefones;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Endereco> enderecoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public ArrayList<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<String> telefones) {
        this.telefones = telefones;
    }

    public java.util.List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(java.util.List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }
}
