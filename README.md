# Order Management System

## Sobre o projeto
Projeto desenvolvido com foco em **Programação Orientada a Objetos (OOP)**,
aplicando boas práticas de design, separação de responsabilidades e padrões
de projeto.

O objetivo é consolidar conceitos de domínio, agregados, casos de uso e
padrões comportamentais.

---

## Conceitos aplicados
- Programação Orientada a Objetos
- Encapsulamento
- Imutabilidade
- Composição vs Herança
- Aggregate Root
- Domain Model
- Use Cases (Application Layer)
- Strategy Pattern
- Separation of Concerns

---

## Arquitetura do projeto

```text
domain
 ├─ order
 ├─ payment
 └─ shipping

application
 ├─ order
 ├─ payment
 └─ shipping

main 
```

---

## Como executar o projeto

### Pré-requisitos
- Java 17 ou superior
- IDE Java (IntelliJ IDEA recomendado)

### Passo a passo
1. Clone o Repositório
```bash
git clone https://github.com/iuxie/order-management-oop-java
```
2. Abra o projeto na sua IDE
3. Navegue até a classe:
```text
br.com.iurexavier.ordermanagement.main.Main
```
4. Execute o método main

O console exibirá o fluxo completo:
- Criação do pedido
- Pagamento
- Envio
- Entrega

---

## Objetivo do projeto

Este projeto foi criado para:
- Consolidar conceitos avançados de OOP
- Praticar design de código limpo
- Servir como base para evolução futura (testes, persistência, etc.)

---

## Autor

**Iure Xavier**, Estudante de Engenharia de Software. Foco em
desenvolvimento back-end e boas práticas de programação