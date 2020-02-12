Desafio Sensedia

Esse é o projeto realizado no desafio oferecido pela Sensedia, trata-se de uma api rest com a capacidade que expõe dois endpoints, um para gerar um token de autenticação, e outro servir os resultados ordenados dos salarios dos deputados, sendo que em ambos os endpoints são consumidos de API's disponibilizadas pela Sensedia.
Para realizar a requisão no metodo no endpoint "localhost:8080/sortSalary", é necessário antes gera um tocken fornecido no endpoint "localhost:8080/getToken", informando id do usuário

Tecnologias Utilizadas:
    Java (versão 1.8)
    Spring Boot (versão 2.2.2.RELEASE) - Framework para desenvolvimento de API's Rest
    Swagger (versão 2.9.2)- Assistente de documentação e testes para API's rest
    Maven (versão 4.0.0)

Requisitos para execução projeto:
    Em ambiente de desenvolvimento:
        Java versão 1.8 ou +
        Maven 3.3.3 ou +
        IDE com suporte para código Java
        Ferramenta capaz de fazer requisição rest do tipo post ou um projeto front-end para a mesma finalidade
                        
   Em ambiente de Produção:
        Java versão 1.8 ou +
        Servidor de aplicação
        Ferramenta capaz de fazer requisição rest do tipo post ou um projeto front-end para a mesma finalidade

Forma de execução
      Em ambiente de desenvolvimento
        1 - Gerar build com o comando "mvn install" 
        2 - No diretório do projeto dentro da pasta target executar o jar gerado com o comando "java -jar <nome do arquivo>"

      Em ambiente de Produção em outro servidor de aplicação
        1 - Adicionar dependencia .... no arquibo pom.xml
            
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                    <version>2.2.2.RELEASE</version>
                </dependency>

        2 - Alterar o pom.xml adicinando a o parametro packaging com o valor "war";
            <packaging>war</packaging>
        
        3 - Gerar build com o comando "mvn install" 

        4 - Inserir o arquivo .war gerado no servidor de aplicação desejado.
        
Documentação

Ao subir a aplicação é possivel consultar a url http://localhost:8080/swagger-ui.html#/query-controller/getSalarysUsingGET, onde é disponibilizada uma documentção de como usar a API


