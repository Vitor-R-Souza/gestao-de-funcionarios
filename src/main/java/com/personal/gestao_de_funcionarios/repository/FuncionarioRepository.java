package com.personal.gestao_de_funcionarios.repository;

import com.personal.gestao_de_funcionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByEmail(String email);
}
