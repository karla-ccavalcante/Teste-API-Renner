Exercício Renner API

Caso de Teste: Validação de CEP com a API ViaCEP.

Descrição: Este repositório contém um projeto de automação de teste para validar CEPs utilizando uma API do ViaCEP.
O objetivo é verificar se a API retorna resultados corretos para CEPs válidos e inválidos

Pré-requisitos:

- Cenário 1: CEP Válido
  Requisitos:
  •	O sistema deve ser capaz de fazer uma solicitação HTTP GET para uma URL https://viacep.com.br/ws/CEP/json, onde "CEP" é um CEP válido.
  •	O sistema deve validar se a resposta da API contém um código de status HTTP 200 (OK).
  •	O sistema deve analisar o JSON de resposta e validar se ele contém informações válidas de CEP, como logradouro, bairro, cidade e estado.
  •	O sistema deve apresentar uma mensagem de sucesso ou um log inferior que o teste passou.
  Cenário 2: CEP Inválido
  Requisitos:
  •	O sistema deve ser capaz de fazer uma solicitação HTTP GET para uma URL https://viacep.com.br/ws/CEP/json, onde "CEP" é um CEP inválido.
  •	O sistema deve validar se a resposta da API contém um código de status HTTP 400 (Bad Request) ou outro código adequado para indicar que o CEP está inválido.
  •	O sistema deve analisar o JSON de resposta e validar se ele contém uma mensagem de erro abaixo de que o CEP é inválido.
  •	O sistema deve apresentar uma mensagem de sucesso ou um log inferior que o teste passou.

Arquitetura do Projeto:

Pacotes:
----------------------------------------------------------------
Testes: Pacote responsável pela parte dos testes, utilizando JUnit5 e RestAssured
----------------------------------------------------------------

Libs utilizadas:
----------------------------------------------------------------
Maven: Responsável por gerenciar as dependências utilizadas no projeto.
----------------------------------------------------------------
JUnit5: Dependência para realizar a execução dos testes através da linguagem Java.
----------------------------------------------------------------
Rest Assured: biblioteca de testes automatizados em Java usada para testar APIs RESTful.
----------------------------------------------------------------
Surefire Report: Responsável por gerar relatórios detalhados da execução do teste
----------------------------------------------------------------