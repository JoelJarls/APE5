import java.io.File;

public class EliminarArchivoEstudiantes {
    public static void main(String[] args) {
        
        File archivo = new File("estudiantes.txt");

        
        if (archivo.delete()) {
            
            System.out.println("El archivo 'estudiantes.txt' se eliminó correctamente.");
        } else {
            
            System.out.println("No se pudo eliminar el archivo. Verifique si el archivo existe en la ruta especificada.");
        }
    }
}
