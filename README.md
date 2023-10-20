

Esta documentación proporciona instrucciones detalladas sobre cómo compilar, arrancar, probar y otras operaciones relacionadas con el proyecto.

## Compilación 



1. **Clonar el Repositorio:**
   ```bash
   git clone 
   cd hexagonalTest
   ```

2. **Compilar el Proyecto:**
   ```bash
   mvn clean package
   ```

## Arranque

1. **Arranque del Proyecto:**
   ```bash
   mvn spring-boot:run
   ```


## Pruebas del Proyecto

Con el siguiente comando, el proyecto se despliega automaticamente y realiza los 5 test definidos en 'SpringRestTest.java'

1. **Ejecutar Pruebas Integrales/Unitarias:**
   ```bash
   mvn test
   ```

## Test via Swagger 

La aplicacion tiene la posibilidad de poder ser testeada directamente desde el panel de 'Swagger'

(http://localhost:8080/swagger-ui/index.html)


