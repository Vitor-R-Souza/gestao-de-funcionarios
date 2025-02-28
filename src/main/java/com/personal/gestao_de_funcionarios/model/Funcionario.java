package com.personal.gestao_de_funcionarios.model;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "tb_funcionario")
public class Funcionario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionario_id;

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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "funcionario_telefones",
            joinColumns = @JoinColumn(name = "funcionario_id")
    )
    @Column(name = "telefone")
    private Set<String> telefones;


    @OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER)
    private Set<Endereco> enderecoList = new HashSet<>();

    public Long getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(Long funcionario_id) {
        this.funcionario_id = funcionario_id;
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

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public Set<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(Set<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }
}
