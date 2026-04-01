Todo o trabalho realizado foi com cuidado para que o software não parasse em momento nenhum de funcionar, então criei todas as mudanças para que no final apagasse e adaptasse parte do código

A principio fiz um ajuste na arquitetura para que tenha separação de responsabilidades, Command é onde tem a entradas de dados do usúario, no Service tem as regras de negocio, no Entity tem os dados de cada clase, no Config configura e injete dependências, no principal é onde é feito a orquestração do sistema (App e Menu).

Fiz algumas mudanças no entity para não deixar a classe anêmica, exemplo disso é o filtro no setNome, onde o participante não consegue passar o nome vazio ou em branco, coloquei tambem .trim() que apaga tudo que vem posteriormente a ultima letra

Fiz uma mudança no menu, para deixar de utilizar Switch Case, usei a biblioteca MAP e HASHMAP, para que eu conseguisse utilizar a classe command junto ao menu mas o menu não depende do command

O fluxo de execução do sistema é feito da seguinte forma: O usúario interage com o menu, onde o Command é executado, o Command chama um Service, o Service manipula o Entity onde o resultado é retomado e exibido.

Principios do SOLID:
S -> Single Responsability Principle (SRP)
  Cada classe possui uma unica responsabilidade
  Exemplo:
      - ParticipanteService (Gerencia participantes)
      - ProvaService (Gerencia provas)

O -> Open/Closed Principle (OCP)
  O sistema é aberto para extenção e fechado para modificação
  - Para adicionar um novo comando, basta criar uma nova clase e implementar no Command e adicionar no menu
    Exemplo:
      - menu.registrar(... , Comando);
   
L -> Liskov Substituion Principle (LSP)
  Qualquer implementação do command pode substituir outra sem quebrar o sistema, O menu não precisa saber qual comando vai ser executado

I -> Interface Segregation Principle
  A interface Command é enxuta, assim, nenhuma classe é forçada a implementar metodos que não utiliza

D -> As dependência são injetadas via construtor
