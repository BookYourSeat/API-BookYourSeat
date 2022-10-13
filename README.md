# Book Your Seat - API

## Estrutura

A API foi estruturada de maneira a criar uma boa divisão entre lógicas de negocio, acesso a banco de dados e interface com aplicações externas.
```shell
-BookYourSeat
  |_____ API
  |      |_______ Controllers
  |
  |_____ Core
  |      |______ Entidade
  |                   |_______ Repository
  |                   |_______ Service
  |
  |_____ Domain
         |______ Entidade
                      |______ Model
                      |______ Repository
                      |______ Service
```

## API
Neste módulo encontra-se toda a lógica para interface com aplicações externas.
### Controller

A controller é a primeira camada do nosso sistema, tendo como responsibilidade permitir a interface com aplicações externas via requisição HTTP.
As controllers devem ser implementadas dentro do modulo `API` e pacote `Controllers`.

## Domain
Neste módulo encontra-se toda a representação do domínio da aplicação: modelos das entidades, interface para acesso a camada de banco de dados `Repository` e interface para a camada de regras de negócio `Service`.

### Model
Nosso `Model` é responsável pela representação da nossa entidade como classe. Localizada dentro do módulo `Domain` que representa todos

### Repository
Aqui encontra-se apenas a interface para acesso aos dados da nossa entidade no banco.

### Service
Aqui encontra-se apenas a interface para regras de negocio da nossa entidade.

## Core
Neste módulo encontra-se a implementação da representação definida no `Domain`

### Repository
Neste pacote deve ser implementado as lógicas de acesso ao nosso banco de dados, seguindo a interface previamente definida pelo `Domain`.

### Service
Neste pacote deve ser implementado as regras de negócio para manipulação de nossas entidades, seguindo a interface previamente definida pelo `Domain`.


## Estrutura Final
Desta forma, temos essa arquitetura para nossa API:
![](assets/struct.png)