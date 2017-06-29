# articlestore

Technology Stack : 
  - Java 8
  - Spring Boot
  - Spring MVC
  - Spring Data JPA
  - Spring MVC Test
  - SQL Server
  - lombok (Used only for Logging Purpose)
  - log4j
  
Future Scope :
  - More Test Coverage
  - Better Logging
  - Use of NoSQL DB Specially Document Oriented database 

Implementation Details :
  - Table Structure :
    - article_tbl
    - author_tbl
    - keyword_tbl
    - article_keyword (Many to Many relationship)
  - REST Endpoints
    - Article :
      - Create Article :
        - http://localhost:8080/api/articles
        - Method : POST
      - Get Article By Id
        - http://localhost:8080/api/articles/{id}
        - Method : GET
      - Get Article publised within Date Range
        - http://localhost:8080/api/articles/date?dateFrom=:date2&dateTo=:date2
        - Method : GET
      - Get all Articles
        - http://localhost:8080/api/articles
        - Method : GET
      - Update Article
        - http://localhost:8080/api/articles
        - Method : PUT
      - Delete Article
        - http://localhost:8080/api/articles/{id}
        - Mtheod : DELETE
    - Author :
      - Get All Articles written By an Author
        - http://localhost:8080/api/authors/{id}
        - Method : GET
      - Get All Articles written By an Author (name)
        - http://localhost:8080/api/authors/name/{name}
        - Method : GET
    - Keyword :
      - Get All Articles for Keyword
        - http://localhost:8080/api/keywords/{word}
        - Method : GET
      
