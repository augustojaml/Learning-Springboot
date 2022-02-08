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

<!--
O Spring Framework fornece uma abstração fácil para enviar e-mail usando a interface JavaMailSender, e o Spring Boot fornece configuração automática para ele, bem como um módulo inicial. Dica. Consulte a documentação de referência para obter uma explicação detalhada de como você pode usar o JavaMailSender.
  -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-mail</artifactId>
</dependency>

<!--
O Thymeleaf é uma template engine para projetos Java que facilita a criação de páginas HTML. Sendo assim, ele serve para gerar páginas HTML no lado servidor de forma dinâmica, permitindo a troca de informações entre o código Java e as página HTML, de tal maneira ele garante que o desenvolvedor consiga criar templates de forma mais fácil para suas aplicações.
-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<!--
O AWS SDK para Java simplifica o uso do AWS Services, fornecendo um conjunto de bibliotecas consistentes e familiares para os desenvolvedores de Java. Ele oferece suporte para a consideração do ciclo de vida da API, como gerenciamento de credenciais, novas tentativas, marshaling de dados e serialização.
-->

<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-java-sdk</artifactId>
    <version>LATEST</version>
  </dependency>

<!--
A biblioteca Apache Commons IO contém classes de utilitários, implementações de fluxo, filtros de arquivos, comparadores de arquivos, classes de transformação endian e muito mais.
O Apache Commons IO é uma biblioteca de utilitários para auxiliar no desenvolvimento da funcionalidade de IO

 -->
 <dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>LATEST</version>
</dependency>


<!--
imgscalr é uma biblioteca de manipulação e escala de imagem de práticas recomendadas simples e eficiente implementada em Java puro.
 -->

<dependency>
  <groupId>org.imgscalr</groupId>
  <artifactId>imgscalr-lib</artifactId>
  <version>4.2</version>
</dependency>
```
