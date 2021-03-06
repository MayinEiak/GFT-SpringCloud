# Prueba habilidades Técnicas GFT

Código para desarrollo de microservicios con Spring Cloud.

### Requisitos

_Requerimientos Técnicos:_
* Java 8
* Gradle 4.10.3
* Docker 19.03
* docker-compose 1.25

### Pasos para ejecutar cada uno de los componentes del proyecto

 _Entrar a la carpeta de cada uno de los componentes "/config", "/eureka-server", "/ms-client", "/ms-bussiness", "/ms-persistence", "/zuul" y ejecutar el siguiente comando para generar cada uno de los jars_

```
	gradle clean bootJar
```

_Con los jars generados, construir las imagenes de docker utilizando los archivos "docker-compose.yml" y ".env", ejecutar el siguiente comando dentro de la carpeta princpal del repoitorio_

```
	docker-compose --env-file .env build
```

_Con las imagenes creadas, construir los contenedores de cada componente/microservicio utilizando los archivos "docker-compose.yml" y ".env", ejecutar el siguiente comando dentro de la carpeta princpal del repositorio_

```
	docker-compose --env-file .env up -d 
```

_Para detener y eliminar todos los contenedores docker asi como la net creada, ejecutar el siguiente comando"_

```
	docker-compose down 
```

#### Despliegue

_El componente que se debe desplegar primero es el "Spring Cloud Config" que corresponde a la carpeta "/config", de los contrario todos los demás componentes se desplegaran de manera erronea ya que "Spring Cloud Config" contiene los archivos de propiedades de todos los demás componentes_

_Cada componente esta configurado para que no se pueda desplegar hasta que no este el "Spring Cloud Config" desplegado previamente, por lo que unicamente se debe ejecutar el comando anterior y todos los componentes se desplegaran de forma correcta_

#### Notas

_Para visualizar el swagger del API, abrir un navegador y colocar la siguiente ruta cambiando "url" por la ip donde se hayan levantado todos los componetes del proyecto_

```
	http://<url>:9090/client-service/swagger-ui.html
```

_Para visualizar el dashboard de Eureka, abrir un navegador y colocar la siguiente ruta cambiando "url" por la ip donde se hayan levantado todos los componetes del proyecto_

```
	http://<url>:8761
```
