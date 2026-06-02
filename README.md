#  Personal Finance Tracker (PFT)

Bem-vindo ao **Personal Finance Tracker** (Rastreador de Finanças Pessoais) Este é um projeto desenvolvido em **Java Puro** com o objetivo de criar uma ferramenta prática e eficiente para o controle de gastos e receitas do dia a dia.

---

## Escopo do Projeto

O objetivo principal deste projeto é ajudar o usuário a gerenciar sua vida financeira de forma descomplicada. Ele permite categorizar as movimentações de dinheiro para dar uma visão clara de onde vêm e para onde vão seus gastos.

### O que o sistema faz atualmente:
*   **Cadastro de Transações:** Registra entradas (Receitas) e saídas (Despesas) financeiras.
*   **Gestão de Categorias:** Cria e organiza categorias (como Alimentação, Salário, Lazer).
*   **Balanço Consolidado:** Calcula automaticamente o total acumulado de receitas, o total de despesas e exibe o saldo líquido em tempo real.
*   **Interface Interativa:** Menu interativo via terminal com navegação contínua e tratamento de erros.

---

##  Arquitetura do Software

Para garantir que o projeto seja fácil de testar, manter e escalar no futuro, adotamos o padrão de **Arquitetura em Camadas** dividida da seguinte forma:

```text
com.finance.tracker
├── model         # Definição das entidades (Transaction, Category, TransactionType)
├── repository    # Camada de persistência de dados (Memória/Arquivos)
├── service       # Regras de negócio e validações lógicas do sistema
└── ui            # Interface e ponto de entrada da aplicação (Main.java)
```

### Principios aplicados ao projeto:
*   **SOLID (Inversão de Dependências):** Os serviços dependem de abstrações (interfaces de repositórios) e não de implementações diretas. Isso torna o código flexível para trocar o armazenamento a qualquer momento.
*   **Encapsulamento:** Todas as variáveis de classe são privadas, expostas de forma segura apenas por Getters e Setters.

---

## Próximos Passos (Roadmap de Evolução)

A ideia principal é criar uma aplicação que esta evoluindo desde uma interface simples ate uma interface grafica completa. 
1.  **Fase 1: Fundação em Java Puro & CLI** (Concluída)
2.  **Fase 2: Interatividade e Tratamento de Erros** (Em andamento! ⚙️)
3.  **Fase 3: Persistência Permanente** (Migração para Banco de Dados Relacional H2 com JDBC).
4.  **Fase 4: Integração Spring Boot** (Criação de uma API RESTful completa).

---

Este projeto é minha principal forma prática de estudos no momento, tudo aquilo que esta sendo aplicado nelo esta sendo fruto de algumas horas de cursos e leituras sobre a linguagem de programação JAVA, portanto ele este em constante evolução e sempre apresentando mudanças a medida que vou aprendendo alternativas melhores a determinados casos.
