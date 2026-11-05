import java.io.File;
import java.io.IOException;

public class CrearArchivoCurso {
    public static void main(String[] args) {
        // 2. Crear un objeto de tipo File para "curso.txt"
        File archivo = new File("curso.txt");

        // 6. Utilizar try-catch para controlar posibles errores de I/O
        try {
            // 3. Utilizar el método createNewFile()
            // 4. Comprobar si el archivo se creó correctamente o si ya existe
            if (archivo.createNewFile()) {
                System.out.println("El archivo se creó correctamente.");
            } else {
                System.out.println("El archivo ya existe en el directorio.");
            }

            // 5. Mostrar el nombre del archivo utilizando getName()
            System.out.println("Nombre del archivo: " + archivo.getName());

        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar crear el archivo: " + e.getMessage());
        }
    }
}
