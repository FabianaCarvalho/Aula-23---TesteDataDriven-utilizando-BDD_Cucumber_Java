# Aula-23---TestesDataDriven-utilizando-BDD_Cucumber_Java

Criados cenários relacionado a Locadora

1) Filme alugado com sucesso
2) Não pode alugar um filme sem estoque

#Scenario outline

3) Deve dar condições especiais para categoria extendida
   
    Exemplos: 
    
    | preco | tipo      | valor | qteDias     | pontuacao |  
    |   4   | extendido |  8    |      3      |     2     |  
    |   4   |  comum    |  4    |      1      |     1     |  
    |   10  | extendido |  20   |      3      |     2     |  
    |   5   |  semanal  |  15   |      7      |     3     |  
