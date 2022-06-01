## Microservislerde swagger için kayıt oluştururken;
application.properties altında aşağıdaki tanım eklenmelidir.

>spring.mvc.pathmatch.matching-strategy=ant_path_matcher

## Microservis tanımı yaparken api gateway üzerinde;

İlgili mikroservisin default pathi aşağıdaki şekilde properties dosyasına eklenmelidir.

>server.servlet.context-path=/product-service



