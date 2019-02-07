#language: pt
Funcionalidade: Alugar Filme
  Como um usuário
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entregas

  Cenário: 1) Devo alugar um filme com sucesso
  	| estoque | 2 |
  	| preco   | 3 |
    Dado um filme com estoque de 2 unidades
    E que o preço do aluguel seja R$3
    Quando alugar
    Então o preço do aluguel será de R$3
    E a data de entrega será no dia seguinte
    E o estoque do filme será 1 unidade

  Cenário: 2) Não deve alugar filme sem estoque
    Dado um filme com estoque de 0 unidades
    Quando alugar
    Então não será possivel por falta de estoque
    E o estoque do filme será 0 unidade

#Scenario outline
  Esquema do Cenário: 3) Deve dar condições especiais para categoria extendida
    Dado um filme com o estoque de 2 unidades
    E que o preço de aluguel seja de <preco>
    E que o tipo de alguel seja <tipo>
    Quando alugar
    Então o preço do aluguel será <valor>
    E a data de entrega será em <qteDias>
    E a pontuação recebida será de <pontuacao> pontos
    
    
    Exemplos: 
    
    | preco | tipo      | valor | qteDias     | pontuacao |
    |   4   | extendido |  8    |      3      |     2     |
    |   4   |  comum    |  4    |      1      |     1     |
    |   10  | extendido |  20   |      3      |     2     |
    |   5   |  semanal  |  15   |      7      |     3     |
