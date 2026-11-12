import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DescifradoMensaje {

    public static void main(String[] args) {
        File archivo = new File("mensaje.txt");
        int totalCaracteres = 0;

        // Verificación de existencia del archivo
        if (!archivo.exists()) {
            System.err.println("Error: El archivo 'mensaje.txt' no se encuentra.");
            return;
        }

        System.out.println("=== TRANSMISIÓN RECIBIDA DESDE LA ESTACIÓN ESPACIAL ===");

        // Apertura del flujo con try-with-resources
        try (FileReader lector = new FileReader(archivo)) {
            int caracter;

            // read() devuelve el valor entero (ASCII/Unicode) del carácter o -1 al llegar al final del archivo (EOF)
            while ((caracter = lector.read()) != -1) {
                // Conversión explícita (cast) de int a char para imprimir el carácter real
                System.out.print((char) caracter);
                totalCaracteres++;
            }

            System.out.println("\n-----------------------------------------------------");
            System.out.println("Total de caracteres procesados: " + totalCaracteres);

        } catch (IOException e) {
            System.err.println("Error al leer el mensaje de emergencia: " + e.getMessage());
        }
    }
}
