import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResultadosParque {

    public static void main(String[] args) {
        File archivo = new File("resultados.txt");

        if (!archivo.exists()) {
            System.err.println("Error: El archivo 'resultados.txt' no existe.");
            return;
        }

        int puntajeTotal = 0;
        int puntajeMaximo = Integer.MIN_VALUE;
        String nombrePuntajeMaximo = "";
        int totalParticipantes = 0;

        System.out.println("=== RESULTADOS DEL PARQUE DE AVENTURAS ===");

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue; // Omitir líneas vacías
                }

                // Asume formato "Nombre - Puntaje" o "Nombre, Puntaje"
                String[] partes = linea.split("[-,]");

                if (partes.length >= 2) {
                    String nombre = partes[0].trim();
                    int puntaje = Integer.parseInt(partes[1].trim());

                    totalParticipantes++;
                    puntajeTotal += puntaje;

                    System.out.println("Participante " + totalParticipantes + ": " + nombre + " | Puntaje: " + puntaje);

                    // Actualización del puntaje máximo
                    if (puntaje > puntajeMaximo) {
                        puntajeMaximo = puntaje;
                        nombrePuntajeMaximo = nombre;
                    }
                }
            }

            System.out.println("-------------------------------------------");
            if (totalParticipantes > 0) {
                System.out.println("Total de participantes: " + totalParticipantes);
                System.out.println("Suma total de puntajes: " + puntajeTotal);
                System.out.println("Puntaje más alto: " + puntajeMaximo + " (Ganador/a: " + nombrePuntajeMaximo + ")");
            } else {
                System.out.println("No se encontraron registros válidos en el archivo.");
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo de resultados: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Se encontró un puntaje que no es un número entero válido.");
        }
    }
}
