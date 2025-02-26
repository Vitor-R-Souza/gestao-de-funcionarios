```mermaid
classDiagram
  class Funcionario {
      +String nome
      +int idade
      +String email
      +String cargo
      +String departamento
      +String[] telefone
      +Endereco[] endereco
  }

  class Endereco {
      +String estado
      +String cidade
      +String bairro
      +String rua
      +String complemento
      +String cep
  }

  Funcionario "1" o-- "*" Endereco : possui
```
