# Ordinario_LPII
 Resolucion de Examen Ordinario LPII 2024
Desafio de Lp2

Objetivos
Implementar el patrón Repository en Quarkus utilizando un archivo data.json como fuente de datos.
Utilizar Jackson Mapper para mapear datos JSON a una clase Java.
Realizar operaciones CRUD y desarrollar funcionalidades adicionales para calcular el promedio de gastos y filtrar por rango de fechas.
Exponer estas funcionalidades a través de un servicio REST.
Instrucciones
Crea un proyecto en Quarkus para implementar las funcionalidades solicitadas.
Utiliza el archivo data.json provisto como fuente de datos.
Sigue el enunciado detallado para implementar el modelo, el repositorio y el servicio REST.
Asegúrate de probar todos los endpoints utilizando curl, Postman o cualquier otra herramienta de tu elección.
Al finalizar, sube tu código a un repositorio en GitHub o entrega el proyecto comprimido en formato ZIP.
Parte 1: Configuración del Proyecto
Crea un proyecto en Quarkus utilizando Maven o Quarkus CLI.

Agrega las siguientes dependencias en tu archivo pom.xml:

<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-resteasy</artifactId>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
</dependency>
Coloca el archivo data.json en la carpeta src/main/resources con el siguiente contenido:

[
  {"descripcion": "aaaaaa & Max", "id": 1, "fecha": 1724198400000, "monto": 150000},
  {"descripcion": "Universidad", "id": 2, "fecha": 724198400000, "monto": 500000},
  {"descripcion": "string", "id": 123, "fecha": 1646870400000, "monto": 0}
]
Parte 2: Modelo
Crea una clase Gasto.java en el paquete com.example.model con los siguientes atributos:

id (int)
descripcion (String)
fecha (long) – en formato timestamp
monto (double)
Incluye los getters y setters necesarios.

Parte 3: Repositorio
Crea una clase GastoRepository.java en el paquete com.example.repository con las siguientes funcionalidades:

Operaciones CRUD:

Create: Agregar un nuevo gasto.
Read: Obtener un gasto por su ID.
Update: Actualizar un gasto existente.
Delete: Eliminar un gasto por su ID.
Obtener todos los gastos.
Operaciones adicionales:

Calcular el promedio de los gastos.
Filtrar los gastos por rango de fecha. Recibe dos parámetros: fechaInicio y fechaFin.
Utiliza Jackson para leer y escribir el archivo data.json.

Parte 4: Servicio REST
Crea una clase GastoService.java en el paquete com.example.service que exponga los siguientes endpoints:

Método HTTP	Path	Descripción
GET	/gastos	Obtener todos los gastos.
GET	/gastos/{id}	Obtener un gasto por su ID.
POST	/gastos	Agregar un nuevo gasto.
PUT	/gastos/{id}	Actualizar un gasto existente.
DELETE	/gastos/{id}	Eliminar un gasto por su ID.
GET	/gastos/promedio	Obtener el promedio de los gastos.
GET	/gastos/rango	Obtener gastos por rango de fecha.
Parámetros para Filtrar por Rango de Fecha
inicio: Fecha de inicio en formato timestamp (long).
fin: Fecha de fin en formato timestamp (long).
Ejemplo de solicitud para filtrar por rango de fecha:
Obs: Pueden manejarlo tambien como "2021-10-10" decidan cual les resulta mas sencillo.

curl "http://localhost:8080/gastos/rango?inicio=1609459200000&fin=1724198400000"
Parte 5: Pruebas
Prueba cada uno de los endpoints creados con curl o Postman. Asegúrate de cubrir los siguientes casos:

Agregar un nuevo gasto.
Obtener un gasto existente por su ID.
Actualizar un gasto existente.
Eliminar un gasto por su ID.
Obtener el promedio de los gastos.
Filtrar gastos por rango de fechas.
Entrega
Sube tu proyecto a un repositorio en GitHub.
Incluye un README.md con instrucciones para ejecutar el proyecto y ejemplos de las solicitudes a los endpoints.
Puntaje
Criterio	Puntos
Correcta implementación del modelo	10
Funcionalidad del repositorio CRUD	20
Funcionalidad para calcular promedio	10
Filtrado por rango de fechas	10
Servicio REST con todos los endpoints	20
Correcta manipulación del archivo JSON	10
Pruebas exitosas de los endpoints	10
Código limpio y buenas prácticas	10
Total	100
¡Buena suerte! 🚀



