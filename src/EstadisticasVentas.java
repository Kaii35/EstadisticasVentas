import java.util.ArrayList;
import java.util.Scanner;

public class EstadisticasVentas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> ventas = new ArrayList<>();

        System.out.println("Ingrese las ventas diarias. Escriba 'fin' para terminar.");
        while (true) {
            System.out.print("Venta: ");
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }
            try {
                double venta = Double.parseDouble(entrada);
                ventas.add(venta);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }

        double total = calcularTotalVentas(ventas);
        double promedio = calcularPromedioVentas(ventas);

        System.out.println("Total de ventas del día: " + total);
        System.out.println("Promedio de ventas del día: " + promedio);

        scanner.close();
    }

    public static double calcularTotalVentas(ArrayList<Double> ventas) {
        double total = 0;
        for (double venta : ventas) {
            total += venta;
        }
        return total;
    }

    public static double calcularPromedioVentas(ArrayList<Double> ventas) {
        if (ventas.isEmpty()) {
            return 0;
        }
        double total = calcularTotalVentas(ventas);
        return total / ventas.size();
    }
}