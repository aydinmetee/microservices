## Microservislerde swagger için kayıt oluştururken;

application.properties altında aşağıdaki tanım eklenmelidir.

> spring.mvc.pathmatch.matching-strategy=ant_path_matcher

## Microservis tanımı yaparken api gateway üzerinde;

İlgili mikroservisin default pathi aşağıdaki şekilde properties dosyasına eklenmelidir.

> server.servlet.context-path=/product-service

Swagger-UI'a product servis için örnek olarak bu adresten ulaşılabilir.
> http://localhost:8080/product-service/swagger-ui/index.html#/



