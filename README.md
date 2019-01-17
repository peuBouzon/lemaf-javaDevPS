# lemaf-javaDevPS
Atividade do processo seletivo para desenvolvedor Java no LEMAF

Instruções de uso:
 - Navegue até a pasta src do projeto.
 - Caso deseje alterar a entrada, edite o arquivo entrada.txt
 - Execute o arquivo TesteMain
 - Os arquivos iniciados com Test apresentam os testes unitários das funções mais relevantes
 
 Informações sobre a implementação:
  - Os carros são alocados aos clientes de acordo com sua disponibilidade na frota. Digamos que em uma linha do arquivo de texto seja feito o aluguel de um carro até o dia 10 deste mês, em uma linha subsequente, é possível alugar este mesmo carro, desde que a data de retirada seja após o dia 10.
  - Após o preço, a prioridade é o veículo com mais baixa capacidade que atende aos requisitos do cliente. Desta forma, para uma capacidade desejada de 2 lugares, se o preco da Ferrari (2 lugares) e do Golf (4 lugares) for o mesmo, então a Ferrari será escolhida para que o carro de maior capacidade atenda a outros clientes quem necessitem de maior capacidade.
  - Os teste unitários foram feitos por meio do jUnit.
  
