# Sudoku em Java (Swing)

Este projeto é uma implementação de um jogo **Sudoku** desenvolvido em **Java**, utilizando **Swing** para a interface gráfica.  
O objetivo é aplicar conceitos de programação orientada a objetos, Collections e manipulação de eventos, conforme proposto em desafios acadêmicos e da plataforma DIO.

---

## Funcionalidades

- Interface gráfica com Swing
- Tabuleiro 9x9 organizado em blocos 3x3
- Células fixas e células editáveis
- Validação automática:
  - Linha
  - Coluna
  - Bloco 3x3
- Destaque visual:
  - Valores válidos em preto
  - Valores inválidos em vermelho
- Detecção automática de conclusão do Sudoku
- Leitura de valores iniciais a partir de arquivo

---

## Tecnologias Utilizadas

- Java
- Swing
- Collections (`List`, `Set`)
- Stream API
- DocumentFilter

---

## Estrutura do Projeto

- `Main` – inicialização da aplicação
- `UI` – interface gráfica
- `Celula` – modelo de uma célula do Sudoku
- `Controlador` – regras do jogo e validações
- `FiltroCelula` – controle e validação de entrada do usuário
- `valor_fixo.txt` – arquivo com os valores iniciais do tabuleiro

---

## Regras do Jogo

- Cada número de 1 a 9 deve aparecer apenas uma vez:
  - em cada linha
  - em cada coluna
  - em cada bloco 3x3
- Células fixas não podem ser alteradas
- O jogo termina quando todas as células estão preenchidas corretamente

---

## Como Executar

1. Clone o repositório
2. Certifique-se de que o arquivo `valor_fixo.txt` está no caminho correto
3. Execute a classe `Main`
4. Preencha o tabuleiro respeitando as regras do Sudoku

---

## Objetivo Acadêmico

Projeto desenvolvido com fins educacionais, focando em:
- Programação orientada a objetos
- Uso de Collections
- Manipulação de eventos em interfaces gráficas
- Validação de regras de negócio

---

## 📄 Licença

Projeto de uso educacional.
