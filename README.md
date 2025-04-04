#url del proyecto:

- https://roadmap.sh/projects/weather-api-wrapper-service
  
# Proyecto API de Clima

## Descripción

Esta es una API para Obtener los datos del clima.

## Tecnologías Utilizadas

- Java 21
- Spring Boot

- OpenWeatherMap (API de donde se consulta los datos)

## Funcionalidades

- Obtener los datos del clima de una parte como( PAIS o CIUDAD)
  



## Instalación y Ejecución

Sigue estos pasos para descargar y ejecutar el proyecto en tu máquina utilizando Docker Compose:

1. Clona el repositorio:

    ```bash
    git clone https://github.com/usuario/proyecto-tareas.git
    cd proyecto-tareas
    ```

3. Accede a la API desde tu cliente REST favorito o desde la from que viene en el repo (index.html).

## Variables de Entorno

Registrate en  OpenWeatherMap.com para octener una key y guardada en application.properties / api.key:

Asegúrate de configurar estos valores correctamente en el archivo

## Endpoints

| Método | URL                                          | Autorización | Body (JSON)                               |
|--------|----------------------------------------------|--------------|-------------------------------------------|
| POST   | `http://localhost:8081/api/weather/city`     | No           | `{ "city": "Santo Domingo" }`             |



