import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = "productos.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese el precio unitario: ");
            double precio = Double.parseDouble(sc.nextLine());

            System.out.print("Ingrese la cantidad disponible: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            // Cálculo del valor total
            double valorTotal = precio * cantidad;

            // Formato de registro en el archivo
            String registro = String.format("Producto: %s | Precio: $%.2f | Cantidad: %d | Total: $%.2f",
                    nombre, precio, cantidad, valorTotal);

            bw.write(registro);
            bw.newLine();

            System.out.println("\nProducto registrado exitosamente en " + nombreArchivo + ".");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un valor numérico válido.");
        } finally {
            sc.close();
        }
    }
}
