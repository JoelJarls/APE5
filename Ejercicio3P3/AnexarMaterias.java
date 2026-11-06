import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AnexarMaterias {
    public static void main(String[] args) {
        String nombreArchivo = "materias.txt";
        String[] nuevasMaterias = {
            "Sistemas Operativos",
            "Bases de Datos"
        };

        // 1. Configuración de FileWriter en modo anexar (append = true)
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            
            // 2. Añadir nuevas asignaturas al final con newLine()
            for (String materia : nuevasMaterias) {
                escritor.write(materia);
                escritor.newLine();
            }

            System.out.println("Nuevas materias anexadas correctamente.");

        } catch (IOException e) {
            System.err.println("Error al anexar información al archivo: " + e.getMessage());
        }
        // 3 y 4. El flujo se cierra automáticamente liberando el archivo.
    }
}
