                        Execução do projeto

Criar um banco de dados no Mysql com o nome teste_nts rodando na porta 3306 ou se preferir entrar no application.properties do projeto
que se encontra no pacote src/main/resources e efetuar as alterações conforme as configurações do seu banco de dados Mysql.

O serviço esta utilizando  Hibernate por isso não necessita se preocupar com a criação de tabelas e campos pois na sua primeira 
execução toda estrutura sera criada.

Sera criada a tabela "campanha" e nela seus respectivos campos que serão  utilizados pelo serviço.

Para efetuar o start da aplicação devera ser executada a classe ApplicationStart que se encontra no pacote br.com.campanha.restful, para efetuar os testes
JUnit  executar a classe CampanhaControllerTest que se encontra no pacote br.com.campanha.restful.integration.controller

Caso necessite efetuar o teste de um GET via Browser chamar a URL http://localhost:8080/rest/campanha/ e seu respectivo id caso queira ou caso nao insira o id sera retornado no browser todos os registros.


                                   Respostas testes 4 e 5

4)O que é Deadlock? Detalhe um pouco sobre o caso e como você poderia resolver isso.

REsposta: Ocorre quando um processo síncrono fica travado e assim parando os outros processos que estão à espera do 
primeiro processamento.

Um exemplo: Uma classe de conexão com o banco de Dados onde o desenvolvedor não encerra a conexão com o 
banco de dados, como a requisição.


5)Uma das grandes inclusões no Java 8 foi a API Stream. Com ela podemos fazer diversas operações de loop, filtros, maps, 
etc. Porém, existe uma variação bem interessante do Stream que é ParallelStreams. Descreva com suas palavras quando 
qual é a diferença entre os dois e quando devemos utilizar cada um deles. 

Resposta: Stream - Seu processamento e síncrono, ou seja, um processo depende do outro Exemplo: Coleção A é iniciada portanto a Coleção B do será iniciada quando o processo A terminar.


ParallelStreams - Seu processamento assíncrono e independente e divido em paralelo, exemplo temos uma coleção A,B,C,D todas eles podem ser processadas independendo uma da outra.

Obs: A decisão para a melhor implementação depende do que será implementado, caso necessite de uma implementação que não dependa da outra será melhor usar ParallelStreams caso uma 
dependa da outra o ideal e usar Stream.
	Outro fator importante e a performance, pois como a ParallelStreams é executado paralelamente e sua performance depende bastante do número de processadores que a máquina utiliza.

