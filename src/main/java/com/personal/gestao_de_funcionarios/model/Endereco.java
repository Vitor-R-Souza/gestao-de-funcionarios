package com.personal.gestao_de_funcionarios.model;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity(name = "tb_endereco")
public class Endereco implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Endereco_id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Column(nullable = true)
    private String estado;

    @Column(nullable = true)
    private String cidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = true)
    private String complemento;

    @Column(nullable = false)
    private String cep;

    public Long getId() {
        return Endereco_id;
    }

    public void setId(Long id) {
        this.Endereco_id = id;
    }

    public Long getEndereco_id() {
        return Endereco_id;
    }

    public void setEndereco_id(Long endereco_id) {
        Endereco_id = endereco_id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
