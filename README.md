Este proyecto en Java implementa un sistema simple de chat entre un servidor y un cliente utilizando sockets. 
La comunicación se realiza mediante mensajes de texto, y el servidor proporciona opciones de servicio al cliente relacionadas con ventas de viajes online.

Descripción de cada una de las clases incluidas en el proyecto:

Clase `Servidor`:
La clase `Servidor` implementa el servidor de atención al cliente. Aquí hay una descripción de sus componentes:

- `main` método: Este método inicia el servidor en el puerto 12345 y espera conexiones de clientes. Para cada cliente que se conecta, crea un hilo separado (`Thread`) para manejar la comunicación con ese cliente.

- `handleClient` método: Este método maneja la comunicación con un cliente específico. Se encarga de enviar opciones al cliente, recibir la opción seleccionada y responder en consecuencia.
- Las opciones incluyen consultar destinos disponibles, reservar un viaje, preguntar sobre ofertas y promociones, hablar con un agente de servicio al cliente, y salir.

Clase `Cliente`:
La clase `Cliente` implementa el cliente que se conecta al servidor de atención al cliente. Aquí hay una descripción de sus componentes:

- `main` método: Este método inicia el cliente y se conecta al servidor en localhost en el puerto 12345. Utiliza un hilo para leer mensajes del servidor en segundo plano y otro hilo para enviar mensajes al servidor.

- Hilo de lectura del servidor: Un hilo que se ejecuta en segundo plano para leer los mensajes del servidor y mostrarlos en la consola del cliente.

- Bucle principal de envío del cliente: Un bucle que solicita mensajes al usuario desde la consola y los envía al servidor.

Ambas clases utilizan las clases `Socket`, `ServerSocket`, `Scanner` y `PrintWriter` para manejar la entrada y salida de datos a través de la red.
La comunicación entre el cliente y el servidor se realiza mediante mensajes de texto, y el servidor proporciona opciones específicas de servicio al cliente en este caso simulando un servicio de ventas de viajes online.
