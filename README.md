Todo o trabalho realizado foi com cuidado para que o software não parasse em momento nenhum de funcionar, então criei todas as mudanças para que no final apagasse e adaptasse parte do código

No primeiro Commit fiz ajuste na arquitetura, separei o projeto entre 4 packages (Principal, Entity, Service e Command).

Participante
Coloquei o participante no entity, criando um construtor e colocando restrições no set, para que o nome não passe vazio ou nulo e para que o email não 
passe sem o "@".
O participante no service ele basicamente vai criar um ArrayList, com todos os participante e estanciei a classe do entity
O participante no Command foi criado apenas para receber os dados e enviar para o service
