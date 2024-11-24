package Main;

import Models.ConversionService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            // Mostrar el menu principal
            System.out.println("### Menú Principal ###");
            System.out.println("1. Convertir moneda");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Llamar a la clase que realiza la conversion
                    ConversionService conversionService = new ConversionService();
                    conversionService.performConversion(scanner);
                    break;
                case 0:
                    // Opcion para salir
                    System.out.println("¡Gracias por usar el convertidor!");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, intente nuevamente.");
            }

        } while (option != 0);

        scanner.close();
    }
}
