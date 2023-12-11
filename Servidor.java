import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor esperando conexiones...");

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

                    // Crear un hilo para atender al cliente
                    new Thread(() -> handleClient(clientSocket)).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                Scanner input = new Scanner(clientSocket.getInputStream());
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            // Enviar opciones al cliente
            output.println("Bienvenido al servicio de ventas de viajes online. Por favor, elija una opción:");
            output.println("1. Consultar destinos disponibles");
            output.println("2. Reservar un viaje");
            output.println("3. Preguntar sobre ofertas y promociones");
            output.println("4. Hablar con un agente de servicio al cliente");
            output.println("5. Salir");

            // Recibir la opción seleccionada por el cliente
            while (input.hasNextLine()) {
                String clientChoice = input.nextLine();
                System.out.println("Cliente eligió la opción: " + clientChoice);

                // Enviar respuesta al cliente según la opción seleccionada
                switch (clientChoice) {
                    case "1":
                        output.println("Nuestros destinos más populares son: ");
                        output.println(" - Playa del Carmen, México");
                        output.println(" - París, Francia");
                        output.println(" - Tokio, Japón");
                        break;
                    case "2":
                        output.println("Gracias por elegir nuestro servicio de reserva de viajes. ¿A dónde te gustaría viajar?");
                        // Aquí puedes agregar lógica para procesar la reserva
                        break;
                    case "3":
                        output.println("Tenemos varias ofertas y promociones disponibles. ¿En qué te gustaría obtener más información?");
                        // Aquí puedes agregar información sobre ofertas y promociones
                        break;
                    case "4":
                        output.println("Conectando con un agente de servicio al cliente. Por favor, espera...");
                        // Aquí puedes simular la conexión con un agente de servicio al cliente
                        break;
                    case "5":
                        output.println("Gracias por usar nuestro servicio. ¡Hasta luego!");
                        return; // Salir del bucle y cerrar conexión con el cliente
                    default:
                        output.println("Opción no válida. Por favor, elija una opción del 1 al 5.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
