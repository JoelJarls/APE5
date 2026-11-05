import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = "estudiantes.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("--- Estudiante " + i + " ---");
                System.out.print("Ingrese el nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Ingrese la calificación: ");
                double calificacion = Double.parseDouble(sc.nextLine());

                // Guardar en el archivo (2 líneas por estudiante)
                bw.write(nombre);
                bw.newLine();
                bw.write(String.valueOf(calificacion));
                bw.newLine();
            }
            System.out.println("\n¡Datos guardados correctamente en " + nombreArchivo + "!");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato de número inválido.");
        } finally {
            sc.close();
        }
    }
}
