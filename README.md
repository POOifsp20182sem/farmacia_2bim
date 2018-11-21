# IFSP_POO_2SEM2018
Trabalho referente a disciplina de Programação Orientada a Objetos do 4º Semestre de ADS do IFSP-BRA.

Esta é a segunda etapa do projeto. A segunda etapa seguirá os mesmos requisitos da anterior, com o adendo da cobrança do tratamento de excessões, documentação e padrões de projeto.


## Sobre o trabalho
O Sistema de Farmácia deverá ser desenvolvido em uma arquitetura de três camadas. A camada de apresentação deverá ser desenvolvida __manualmente__ utilizando o _framework_ _Java Foundation Class_ (JFC), que consiste, basicamente, das biblotecas _Abstract Window Toolkit_ (AWT) e _Java Swing API_. O banco de dados relacional utilizado será o SGBD MySQL.


## Requisitos Funcinais
- [ ] **RF01**: Manter o cadastro de clientes especiais.
- [ ] **RF02**: Manter o cadastro de medicamentos
- [ ] **RF03**: Gerenciar a abertura e o encerramento do caixa
- [ ] **RF04**: Gerenciar a venda de medicamentos com registro de pagamento em dinheiro ou cartão e com possibilidade de concessão de desconto e emissão de nota fiscal eletronica
- [ ] **RF05**: Gerenciar o estoque, permitindo entrada e saida


## Regras de Negócio
- [ ] **RN01**: Todo aposentado tem direito a 20% de desconto nas compras de qualquer medicamento. Para isso é necessario o cadastro dos aposentados, conforme RF01
- [ ] **RN02**: Num mesmo dia, o caixa pode ser aberto e encerrado quantas vezes forem necessárias
- [ ] **RN03**: Quando o pagamento for realizado em dinheiro, o cliente terá desconto de 5%, exceto os aposentados, conforme RN01
- [ ] **RN04**: Será necessário manter dois tipos de usuário: atendente e gerente. O gerente pode executar todas as funções do sistema; O atendente não pode encerrar o caixa nem conceder descontos especiais

## Padrões de Projeto Escolhidos
Nesta segunda etapa, o projeto deverá empregar dois padrões de projetos não estudados em aula, além dos já estudados. Os seguintes padrões se fazerão em uso aqui:
- [x] **Data Access Object**
- [x] **Factory Method**
- [x] **MVC**
- [x] **Singleton**
- [ ] a definir

## Tratamento de Excessões
O Sistema de Farmácia deverá utilizar as subclasses de _Exception_ e exibi-los utilizando [JOptionPane](https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html).
