import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = "ventas.txt";
        double totalAcumuladoSesion = 0.0;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            System.out.println("=== SISTEMA DE REGISTRO DE VENTAS ===");

            while (true) {
                System.out.print("\nIngrese el nombre del producto (o 'fin' para terminar): ");
                String nombreProducto = sc.nextLine().trim();

                if (nombreProducto.equalsIgnoreCase("fin")) {
                    break;
                }

                System.out.print("Ingrese el precio: ");
                double precio = Double.parseDouble(sc.nextLine());

                System.out.print("Ingrese la cantidad vendida: ");
                int cantidad = Integer.parseInt(sc.nextLine());

                // Cálculo del subtotal
                double subtotal = precio * cantidad;
                double descuento = 0.0;

                // Aplicación de regla de descuento (10% si subtotal >= $100)
                if (subtotal >= 100.0) {
                    descuento = subtotal * 0.10;
                }

                double totalPagar = subtotal - descuento;
                totalAcumuladoSesion += totalPagar;

                // Salida en consola
                System.out.printf("Subtotal: $%.2f\n", subtotal);
                if (descuento > 0) {
                    System.out.printf("Descuento (10%%): -$%.2f\n", descuento);
                }
                System.out.printf("Total a pagar: $%.2f\n", totalPagar);

                // Guardar venta en archivo
                String registroVenta = String.format("Venta: %s | Cant: %d | Subtotal: $%.2f | Desc: $%.2f | Total: $%.2f",
                        nombreProducto, cantidad, subtotal, descuento, totalPagar);
                bw.write(registroVenta);
                bw.newLine();
            }

            // Al finalizar el bucle, si se realizaron ventas, se guarda el total acumulado
            if (totalAcumuladoSesion > 0) {
                bw.write("--------------------------------------------------");
                bw.newLine();
                bw.write(String.format("TOTAL ACUMULADO DE ESTA SESIÓN: $%.2f", totalAcumuladoSesion));
                bw.newLine();
                bw.write("==================================================");
                bw.newLine();
                System.out.printf("\nProceso finalizado. Total acumulado registrado: $%.2f\n", totalAcumuladoSesion);
            } else {
                System.out.println("\nNo se registraron ventas en esta sesión.");
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al manipular el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un valor numérico válido para precio y cantidad.");
        } finally {
            sc.close();
        }
    }
}
