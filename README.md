                        Execução do projeto

Criar um banco de dados no Mysql com o nome teste_nts rodando na porta 3306 ou se preferir entrar no application.properties do projeto
que se encontra no pacote src/main/resources e efetuar as alterações conforme as configurações do seu banco de dados Mysql.

O serviço esta utilizando  Hibernate por isso não necessita se preocupar com a criação de tabelas e campos pois na sua primeira 
execução toda estrutura sera criada.

Sera criada a tabela "campanha" e nela seus respectivos campos que serão  utilizados pelo serviço.

Para efetuar o start da aplicação devera ser executada a classe ApplicationStart que se encontra no pacote br.com.campanha.restful, para efetuar os testes
JUnit  executar a classe CampanhaControllerTest que se encontra no pacote br.com.campanha.restful.integration.controller
