# Reto Tecnico

El proyecto trata sobre la creación de un Api Rest para gestionar una biblioteca.
Para esta Api se está utilizando: 

- Lenguaje: Java
- Proyecto: Maven
- SpringBoot: 3.3.0
- Packaging: Jar
- JDK: 17
- MySQL


## Funciones

- Listar todos los libros
- Buscar un libro por su id
- Agregar un libro
- Modificar un libro
- Eliminar un libro
- Buscar libros por una cadena de texto en el título y autor, devolviendo aquellos libros que contengan dicha cadena.


## Dependencias

- SpringWeb 
- SpringData JPA
- MySQLDriver
- SpringBoot DevTools
- SpringBoot Starter Test


### Dependencias adicionales

- mockito-all -> 2.0.2-beta

Esto para poder realizar las pruebas unitarias.



## Conexión con la base de datos

Configurar la conexión con la base de datos en el aplication.properties

`spring.application.name=Reto Tecnico`

#### Cadena de conexión
`spring.datasource.url=jdbc:mysql://localhost:3306/database`


#### Usuario de la bd

`spring.datasource.username=root`

#### Clave de la bd

`spring.datasource.password=root`

#### Url del proyecto
`server.servlet.context-path=/api`

## Indicaciones

Construir el proyecto con la opción 'Build Proyect'

Ejecutar el Proyecto dando click en src > main > java > RetoTecnicoApplication > click derecho > Run
