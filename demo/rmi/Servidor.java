import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");

        Conversor conversor = celsius -> {
            double fahrenheit = celsius * 1.8 + 32;
            System.out.printf("Servidor: %s C -> %s F%n", celsius, fahrenheit);
            return fahrenheit;
        };

        Registry registro = LocateRegistry.createRegistry(1099);
        Conversor stub = (Conversor) UnicastRemoteObject.exportObject(conversor, 0);
        registro.rebind("Conversor", stub);
        System.out.println("Servidor: Conversor registrado en 127.0.0.1:1099. Enter para salir.");

        // Mantiene vivas las referencias al registro y a la implementación durante la demo.
        try (var entrada = new Scanner(System.in)) {
            entrada.hasNextLine();
        } finally {
            UnicastRemoteObject.unexportObject(conversor, true);
            UnicastRemoteObject.unexportObject(registro, true);
        }
    }
}
