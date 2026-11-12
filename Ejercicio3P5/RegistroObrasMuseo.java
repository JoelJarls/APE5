import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistroObrasMuseo {

    public static void main(String[] args) {
        File archivo = new File("obras.txt");

        // Verificación de existencia del archivo
        if (!archivo.exists()) {
            System.err.println("Error: El archivo 'obras.txt' no existe.");
            return;
        }

        // Map para almacenar el conteo por categoría (Categoría -> Cantidad)
        Map<String, Integer> conteoCategorias = new HashMap<>();
        int totalObras = 0;

        System.out.println("=== CATÁLOGO DE OBRAS DE ARTE ===");

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue; // Omitir líneas en blanco
                }

                // Asumiendo formato "Nombre - Categoría" o "Nombre, Categoría" (separado por guión o coma)
                String[] partes = linea.split("[-,]");

                if (partes.length >= 2) {
                    String nombreObra = partes[0].trim();
                    String categoria = partes[1].trim();
                    totalObras++;

                    System.out.println("Obra " + totalObras + ": \"" + nombreObra + "\" | Categoría: " + categoria);

                    // Actualizar el conteo de la categoría en el Mapa
                    conteoCategorias.put(categoria, conteoCategorias.getOrDefault(categoria, 0) + 1);
                } else {
                    // Si la línea no tiene separador, se muestra completa como registro no estructurado
                    System.out.println("Registro: " + linea.trim());
                }
            }

            // Resumen final de clasificación
            System.out.println("\n-----------------------------------");
            System.out.println("=== CLASIFICACIÓN POR CATEGORÍA ===");
            for (Map.Entry<String, Integer> entrada : conteoCategorias.entrySet()) {
                System.out.println("• " + entrada.getKey() + ": " + entrada.getValue() + " obra(s)");
            }
            System.out.println("-----------------------------------");
            System.out.println("Total general de obras: " + totalObras);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo de obras: " + e.getMessage());
        }
    }
}
