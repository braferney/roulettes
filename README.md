# employees-app

En esta aplicación podrá registrar ruletas, eliminarlas, consultar las ruletas registradas,activar las ruletas, hacer apuestas por color o por numero, consultar las apuestas realizadas.

## Instalación
***
Use los siguientes comandos:
```
$ git clone https://github.com/braferney/roulettes.git
$.\mvnw.cmd spring-boot:run
```
Abrir XAMPP iniciar los modulos de Apache y MySQL.
Navega a `http://localhost/phpmyadmin/` y crear una base datos llamada basedatesroulette. No se tienen que crear las tablas, al momento de ejecutar el código se crean automáticamente.

## Ejecución
Ejecutar `.\mvnw.cmd spring-boot:run` para ejecutar la API.

## Creación y apertura de ruletas

Mediante método POST, colocar `http://localhost:8080/roulettes/`. Por un JSON enviar los datos "roulette" de tipo String que es el nombre que se le asignará a la ruleta creada y "active" de tipo Boolean que es el estado que tendrá la ruleta creada.
Navega a `http://localhost:8080/roulettes/ativate/{id}`. En el campo {id} escribir el id de la ruleta a la que se le desea dar apertura en caso de que esté en estado "active"=false.

## Creación de apuestas

Si se desea realizar apuesta por color. Mediante método POST colocar `http://localhost:8080/bets/color`, por un JSON enviar los datos "idR" de tipo Long que corresponde a la ruleta en la cual se quiere realizar la apuesta, "amount" de tipo Integer que corresponde al valor de la apuesta, "idUser" que corresponde al id del usuario que está realizando la apuesta, "color" que será el color al que se quiere apostar.
Si se desea realizar apuesta por número. Mediante método POST  colocar `http://localhost:8080/bets/number, por un JSON enviar los datos "idR" de tipo Long que corresponde a la ruleta en la cual se quiere realizar la apuesta, "amount" de tipo Integer que corresponde al valor de la apuesta, "idUser" que corresponde al id del usuario que está realizando la apuesta, "number" que será el número al que se quiere apostar.

##Cierre de ruleta

Navega a `http://localhost:8080/bets/close/{id}`, en el campo {id} escribir el id de la ruleta que se desea cerrar.

## Listado de ruletas creadas

Navega a `http://localhost:8080/roulettes` para ver todas las ruletas creadas y comprobar si estan abiertas o cerradas.  