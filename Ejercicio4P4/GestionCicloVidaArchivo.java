import java.io.File;
import java.io.IOException;

public class GestionCicloVidaArchivo {
    public static void main(String[] args) {
        // 1. Objeto File con la ruta especificada
        File archivoTemporal = new File("datos/temporal.txt");

        // 2. Verificación de existencia y creación segura
        if (!archivoTemporal.exists()) {
            try {
                if (archivoTemporal.createNewFile()) {
                    System.out.println("Archivo 'temporal.txt' creado correctamente.");
                }
            } catch (IOException e) {
                System.err.println("Error al crear el archivo temporal: " + e.getMessage());
                return; // Se interrumpe la ejecución si falla la creación
            }
        } else {
            System.out.println("El archivo 'temporal.txt' ya estaba disponible.");
        }

        // 3. Variable de control booleana para simular la confirmación del usuario
        boolean confirmarBorrado = true;

        // 4. Eliminación condicional mediante delete()
        if (confirmarBorrado) {
            boolean eliminado = archivoTemporal.delete();
            System.out.println("¿Operación de eliminación exitosa?: " + eliminado);
        } else {
            System.out.println("Eliminación cancelada por el usuario. El archivo se conserva.");
        }
    }
}
