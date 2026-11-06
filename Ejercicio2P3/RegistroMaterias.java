import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroMaterias {
    public static void main(String[] args) {
        String nombreArchivo = "materias.txt";
        String[] materias = {
            "Programación Orientada a Objetos",
            "Cálculo Diferencial",
            "Física Mecánica",
            "Álgebra Lineal",
            "Estructuras Discretas"
        };

        // 1. Configurar flujo con BufferedWriter y FileWriter
        // 4. Cierre automático utilizando try-with-resources y captura de IOException
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            
            // 2 y 3. Escribir asignaturas y usar newLine()
            for (String materia : materias) {
                escritor.write(materia);
                escritor.newLine();
            }
            
            System.out.println("Escritura completada exitosamente en " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
