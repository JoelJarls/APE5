import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AnalisisPistas {

    public static void main(String[] args) {
        // 1. Definición de la ruta del archivo
        File archivo = new File("pistas.txt");
        int contadorPistas = 0;

        // 2. Verificación de existencia del archivo
        if (!archivo.exists()) {
            System.err.println("Error: El archivo 'pistas.txt' no existe.");
            return;
        }

        System.out.println("=== PISTAS DE LA INVESTIGACIÓN ===");

        // 3. Lectura del archivo línea por línea usando try-with-resources
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            
            while ((linea = lector.readLine()) != null) {
                // Si la línea no está vacía, se muestra y se cuenta como pista
                if (!linea.trim().isEmpty()) {
                    contadorPistas++;
                    System.out.println("Pista " + contadorPistas + ": " + linea);
                }
            }

            System.out.println("-----------------------------------");
            System.out.println("Total de pistas encontradas: " + contadorPistas);

        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
}
