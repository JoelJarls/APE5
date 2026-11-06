import java.io.File;
import java.io.IOException;

public class GestorMetadatosFile {
    public static void main(String[] args) {
        File archivo = new File("datos/prueba.txt");

        // 1. Comprobación previa
        if (archivo.exists()) {
            System.out.println("El recurso ya existe en el disco.");
        } else {
            System.out.println("El recurso no existe. Intentando crearlo...");
            // 2. Creación controlada con try-catch
            try {
                boolean creado = archivo.createNewFile();
                if (creado) {
                    System.out.println("Archivo creado exitosamente.");
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            } catch (IOException e) {
                System.err.println("Error de E/S al crear el archivo: " + e.getMessage());
            }
        }

        // 3. Extracción de información de la ruta
        System.out.println("Nombre del recurso (getName()): " + archivo.getName());
        System.out.println("Ruta especificada (getPath()): " + archivo.getPath());
    }
}
