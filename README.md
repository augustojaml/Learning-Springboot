# Spring Boot

### Dependências

```xml
<!--
O Spring Web é utilizado para criar aplicativos Web, incluindo RESTful, utilizando o Spring MVC. Indispensável para criação aplicações web baseadas em Spring Framework.

@RequestMapping – mapeia requisições REST.

@Controller – define uma classe que contém métodos para estrutura Spring MVC.

@RestController – define uma classe que contém métodos para uma API RESTful.

@RequestBody – mapeia o corpo da solicitação HTTP para um objeto.

@PathVariable – define o recebimento de parâmetros de uma requisição.

@RequestParam – com essa anotação, podemos acessar parâmetros da solicitação HTTP.

@ExcepetionHandler – lida com exceções. A configuração do Spring detecta essa anotação e registra o método como manipulador de exceções para a classe de exceção do argumento e suas interfaces.

@ResponseStatus – com essa anotação, podemos especificar o status HTTP desejado da resposta.

@ModelAttribute – define o modelAttribute que será utilizado em um form HTML. Podemos acessar elementos que já estão no modelo de um MVC @Controller favorecendo a chave do modelo.

@CrossOrigin – ativa a comunicação entre domínios para os métodos manipuladores de solicitações.

@SessionAttributes – declara os atributos da sessão listando os nomes dos atributos do modelo que devem ser armazenados de forma transparente na sessão, servindo como beans de apoio de formulário entre as solicitações subsequentes.
-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!--
Esta ferramenta pode ser utilizada em qualquer projeto Spring e pode melhorar bastante o tempo de desenvolvimento dos seus projetos.
-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <scope>runtime</scope>
  <optional>true</optional>
</dependency>

<!--
Contém a maioria das dependências necessárias para realizar testes da sua aplicação: Junit, AssertJ, Hamcrest, Mockito, entre outros
  -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>

<!--
O Lombok é um framework para Java que permite escrever código eliminando a verbosidade, o que permite ganhar tempo de desenvolvimento para o que realmente é importante. Seu uso permite gerar em tempo de compilação os métodos getters e setters, métodos construtores, padrão builder e muito mais.
-->
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>

<!--
Ele (o Spring Data JPA) é, na verdade, um projeto dentro de um outro maior que é o Spring Data. O Spring Data tem por objetivo facilitar nosso trabalho com persistência de dados de uma forma geral. E além do Spring Data JPA, ele possui vários outros projetos

Spring Data Commons
Spring Data Gemfire
Spring Data KeyValue
Spring Data LDAP
Spring Data MongoDB
Spring Data REST
Spring Data Redis
Spring Data for Apache Cassandra
 -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!--
H2 é um banco de dados relacional escrito em Java. Ele pode ser integrado em aplicativos Java ou executado no modo cliente-servidor. Todos os modos contam com suporte para bancos de dados persistentes e na memória. Não há limite para o número de bancos de dados abertos simultaneamente ou para o número de conexões abertas.
-->
<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <scope>runtime</scope>
</dependency>

<!--
É uma especificação que permite validar objetos com facilidade em diferentes camadas da aplicação. A vantagem de usar Bean Validation é que as restrições ficam inseridas nas classes de modelo.
-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!--
O Connector/J é um driver JDBC do tipo IV e contém todas as características de JDBC para utilizar MySQL
-->

<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>
```
