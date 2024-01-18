# Sobre o Projeto

Projeto de um Portal de Vagas, desenvolvido em Utilizando FrameWork Spring 3.1.7, oferecendo uma api para cadastrar Empresas e Candidatos, gerenciar vagas e se canditar a uma vaga.

## Para Inicializar o projeto

#### Requisitos
    > Java versão 17
    > Maven versão 3.9.3
    > Docker

Faça um clone do projeto com o seguinte comando 
```sh 
git clone https://github.com/Marcos-PauloR/pacto-Back_End.git
```
Entre na pasta do projeto com:
```sh
[foo@fedora dir]$ cd pacto-Back_End
```

Entre na pasta do dockerfile do banco de dados com o seguinte comando:

```sh
[foo@fedora pacto-Back_End]$ cd dockerFiles/bd
```
Gere a imagem do banco de dados:
```sh
[foo@fedora pacto-Back_End]$ docker build -t 'Nome da Imagem' .
```
execute o run do docker:

```sh
[foo@fedora pacto-Back_End]$ docker run --name 'Nome do container' -e POSTGRES_DB='Nome do banco' -e POSTGRES_USER='Usuario do banco'  -e POSTGRES_PASSWORD='Senha do banco' -d 'Nome da imagem criado anteriormente'
```

Com o Banco de dados em execução mudaremos o application.properties para fazer a conexção com o banco de dados:
(encontre ele seguindo o path `src/main/resources`)
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/'nome do banco de dados'
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username='Usuario criado para o banco de dados'
spring.datasource.password='Senha criada para o banco de dados'
```

Tendo alterado isto, execute o comando para subir aplicação com maven pelo:
```sh
mvn spring-boot:run
```

Caso esteja tudo certo sua aplicação executará corretamente.
Os endpoints estarão disponiveis no path:

`localhost:9006/api/pacto`

### Para Personalização dos Endpoints

Caso queira alterar a porta e o context-path vá em:
```sh
[foo@fedora pacto-Back_End]$ cd src/main/resources
```
e dentro de application.properties mude os valores de:
```properties
# Porta da Aplicação
server.port='porta desejada'
server.servlet.context-path='caminho desejado'
```
