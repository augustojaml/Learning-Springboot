# Database

- CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

- web: java -Dserver.port=$PORT -Dspring.profiles.active=prod $JAVA_OPTS -jar target/nelioalves-0.0.1-SNAPSHOT.jar

# Atualização para Spring 2.X.X

- Atualização 1

```java
categoriesRepository.saveAll(Arrays.asList(cat1, cat2));
```

- Atualização 2

```java
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm")
```

- Atualização 3

```java
PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction));
```

- Atualização 4

```java
import javax.validation.constraints.NotEmpty
```

- Atualização 5

```java
List<Category> categories = categoriesRepository.findAllById(ids);
```

- [Spring Data](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)
