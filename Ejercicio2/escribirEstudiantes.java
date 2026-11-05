import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class escribirEstudiantes {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Ingrese el mensaje que desea guardar en estudiantes.txt: ");
        System.out.print("");
        String mensaje = scanner.nextLine();

        
        try (FileWriter writer = new FileWriter("estudiantes.txt", true)) { 
            
            
            writer.write(mensaje + System.lineSeparator());

            
            System.out.println("La información se guardó correctamente en el archivo.");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        } finally {
            
            scanner.close();
        }
    }
}
