# Taller2WebServices

# Demo
Abajo se encuentran los enlaces para ver los vídeos correspondientes de cada parte del taller

[Parte 1 del taller](https://youtu.be/YdrnefPG5SE)

[Parte 2 del taller](https://youtu.be/OAHEqj_9QCw)

# Instrucciones de ejecución
Clonar repositorio https://github.com/BeltranDaniel/Taller2WebServices.git
## Parte 1 del taller
Ingresar a la carpeta "Taller 2 - Parte 1"
### Ejecutar el servidor 
1. Ingresar a la carpeta "serverPaseos"
2. Ejecutar los siguientes comandos 
> mvn clean install

> mvn exec:java
### Ejecutar el cliente 
1. Ingresar a la carpeta "clienteTaller"
2. Ejecutar los siguientes comandos 
> mvn clean install

> mvn exec:java

### ¿Cómo ejecutar cada punto?
Para correr cada uno de los puntos basta con interactuar con la consola del cliente usando las opciones correspondientes:

**Opciones:**
1. Obtener listado de paseos
2. Borrar paseo (por ID)
3. Modificar origen y destino (de un paseo)
4. Crear un paseo

## Parte 2 del taller
Ingresar a la carpeta "Taller 2 - Parte 2

### Ejecutar servidor eureka
1. Ingresar a la carpeta "eurekaserver"
2. Ejecutar los siguientes comandos
> mvn clean install

> mvn spring-boot:run

3. Abrir la ruta http://localhost:8761/ (se debería observar la instancia de eureka corriendo)

### Ejecutar calculadora
1. Ingresar a la carpeta "calculadora"
2. Ejecutar los siguientes comandos
> mvn clean install

> mvn spring-boot:run

### Ejecutar instancias del sumador (Windows)
1. Ingresar a la carpeta "sumador"
2. Ejecutar el siguiente comando
> mvn clean install
3. Ejecutar los siguientes comandos en terminales diferentes
> java -jar -Dserver.port=9999 target/sumador-0.0.1-SNAPSHOT.jar

> java -jar -Dserver.port=9998 target/sumador-0.0.1-SNAPSHOT.jar

### Ejecutar instancias del substractor (Windows)
1. Ingresar a la carpeta "substractor"
2. Ejecutar el siguiente comando
> mvn clean install
3. Ejecutar los siguientes comandos en terminales diferentes
> java -jar -Dserver.port=7999 target/substractor-0.0.1-SNAPSHOT.jar

> java -jar -Dserver.port=7998 target/substractor-0.0.1-SNAPSHOT.jar

### Ejecutar instancias del multiplicador (Windows)
1. Ingresar a la carpeta "multiplicador"
2. Ejecutar el siguiente comando
> mvn clean install
3. Ejecutar los siguientes comandos en terminales diferentes
> java -jar -Dserver.port=8999 target/multiplicador-0.0.1-SNAPSHOT.jar

> java -jar -Dserver.port=8998 target/multiplicador-0.0.1-SNAPSHOT.jar

### Ejecutar instancias del divisor (Windows)
1. Ingresar a la carpeta "divisor"
2. Ejecutar el siguiente comando
> mvn clean install
3. Ejecutar los siguientes comandos en terminales diferentes
> java -jar -Dserver.port=6999 target/divisor-0.0.1-SNAPSHOT.jar

> java -jar -Dserver.port=6998 target/divisor-0.0.1-SNAPSHOT.jar

### ¿Cómo ejecutar cada punto?
Para correr cada punto se puede utilizar la colección de postman "Calculadora.postman_collection.json"que está adjunta en este repositorio.
De forma alternativa se pueden utilizar las siguientes URIs para visualizar las respuestas en el navegador:

**Suma**
* http://localhost:8888/calculadora/suma?a=15&b=20&user=daniel
* http://localhost:8888/calculadora/suma/operaciones


**Resta**
* http://localhost:8888/calculadora/resta?a=20&b=10&user=daniel
* http://localhost:8888/calculadora/resta/operaciones

**División**
* http://localhost:8888/calculadora/div?a=20&b=2&user=daniel
* http://localhost:8888/calculadora/div/operaciones

**Multiplicación**
* http://localhost:8888/calculadora/mult?a=3&b=4&user=daniel
* http://localhost:8888/calculadora/mult/operaciones


