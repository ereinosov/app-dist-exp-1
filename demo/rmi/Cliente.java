import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Uso: java -cp <directorio de clases> Cliente <celsius>");
            System.exit(1);
            return;
        }

        double celsius;
        try {
            celsius = Double.parseDouble(args[0]);
        } catch (NumberFormatException error) {
            System.err.println("Escribe una temperatura con punto decimal, por ejemplo 25.5.");
            System.exit(1);
            return;
        }
        if (!Double.isFinite(celsius)) {
            System.err.println("La temperatura debe ser un número finito.");
            System.exit(1);
            return;
        }

        Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1099);
        Conversor conversor = (Conversor) registro.lookup("Conversor");
        double fahrenheit = conversor.aFahrenheit(celsius);
        System.out.printf("Cliente: %s F%n", fahrenheit);
    }
}
