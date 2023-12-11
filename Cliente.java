import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             Scanner input = new Scanner(socket.getInputStream());
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado al servidor de atención al cliente.");

            // Leer mensajes del servidor
            new Thread(() -> {
                while (input.hasNextLine()) {
                    String serverMessage = input.nextLine();
                    System.out.println("Servidor: " + serverMessage);
                }
            }).start();

            // Enviar mensajes al servidor
            while (true) {
                System.out.print("Cliente: ");
                String clientMessage = scanner.nextLine();
                output.println(clientMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
