# spotify-queue-simulation
## 1️ Cómo compilar la librería
### Desde consola
1. Abrir una terminal.
2. Ubicarse en la raíz del proyecto `queue` (donde se encuentra el `pom.xml`).
```mvn clean compile```
* Limpia compilaciones anteriores.
* Compila el código ubicado en `src/main/java`.

### Desde Eclipse
1. Clic derecho sobre el proyecto `queue`.
2. Seleccionar **Run As → Maven build**.
3. En Goals escribir: ```clean compile```
4. Ejecutar.

## 2️ Cómo instalar en local
### Desde consola
Ubicado en la raíz del proyecto `queue`: ```mvn clean install```
Esto:
* Genera el archivo `.jar`
* Lo instala en el repositorio local de Maven (`.m2`)
* Permite que otros proyectos Maven lo usen como dependencia

### Desde Eclipse
1. Clic derecho sobre el proyecto `queue`.
2. **Run As → Maven build**
3. Goals: ```clean install```

## 3️ Cómo compilar el handler
El proyecto `queueHandler` contiene la lógica de la simulación:
* `Song.java`
* `QueueManagerPlayer.java`
* `App.java` (Main)
Este proyecto tiene configurada en su `pom.xml` la dependencia hacia la librería `queue`.

### Desde consola
Ubicarse en la carpeta raíz de `queueHandler`: ```mvn clean compile```

### Desde Eclipse
1. Clic derecho sobre el proyecto `queueHandler`.
2. **Run As → Maven build**
3. Goals: ```clean compile```

## 4️ Cómo ejecutar desde consola
Para ejecutar la aplicación desde consola utilizando Maven: ```mvn exec:java -Dexec.mainClass="queueHandler.handler.App"```
Este comando ejecuta la clase principal `App`, la cual inicia la simulación del reproductor de música.
La salida en consola mostrará:
* Inicio de playlist
* Canción en reproducción
* Barra de progreso
* Finalización de playlist

## 5️ Explicación del diseño
El sistema fue dividido en dos proyectos Maven independientes:

### Proyecto `queue`
Contiene la implementación manual de la estructura de datos: * `QueueLinked`
Este módulo funciona como una librería reutilizable.

### Proyecto `queueHandler`
Contiene la lógica del reproductor:
* `Song` → Modelo de datos
* `QueueManagerPlayer` → Gestión de reproducción
* `App` → Punto de entrada
Se aplicó separación de responsabilidades:
* La estructura de datos no contiene lógica de negocio.
* La lógica de reproducción no implementa estructuras internas.
* La clase principal solo inicia el sistema.
Esto facilita mantenimiento y reutilización.

## 6️ Decisiones técnicas
* Se utilizó una estructura enlazada manual en lugar de clases nativas de Java para demostrar comprensión de estructuras dinámicas.
* Se dividió en dos proyectos Maven para simular una arquitectura modular.
* Se utilizó prioridad numérica:
  * `1` → Alta
  * `2` → Normal
* Se utilizó `Thread.sleep()` para simular tiempo real.

## 7️ Cómo implementaste la prioridad
Se declararon dos colas independientes: 
```
private QueueLinked<Song> highPriority;
private QueueLinked<Song> normalPriority;
```
Al agregar una canción:
```
if (song.getPriority() == 1) {
    highPriority.enqueue(song);
} else {
    normalPriority.enqueue(song);
}
```

Durante la reproducción:
1. Se vacía completamente la cola de alta prioridad.
2. Luego se reproducen las canciones normales.
Esto garantiza que las canciones importantes se ejecuten primero.

## 8️ Cómo manejaste la simulación de duración
La duración de cada canción se simula utilizando un ciclo:
```
for (int i = 1; i <= song.getDuration(); i++) {
    Thread.sleep(1000);
}
```
Cada iteración representa un segundo real.
Se calcula el progreso proporcional y se construye una barra visual dinámica en consola como:
```[####------] 4s / 10s```
Esto permite simular el comportamiento de un reproductor real.

## Conclusión
El proyecto fue desarrollado en **Eclipse IDE**, utilizando **Java** y gestionado mediante **Maven**.
Se implementó:
* Estructura de datos enlazada manual
* Arquitectura modular con librería reutilizable
* Manejo de prioridades
* Simulación de tiempo real
* Separación clara de responsabilidades
