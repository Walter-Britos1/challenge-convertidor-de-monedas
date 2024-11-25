package Models;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ConversionService {

    // Historial de conversiones 
    private static List<ConversionRecord> history = new LinkedList<>();

    // Método para realizar una conversión
    public static void performConversion(Scanner scanner) {
        System.out.print("Ingresa la moneda base (ej: USD): ");
        String base = scanner.next().toUpperCase();

        System.out.print("Ingresa la moneda de destino (ej: EUR): ");
        String destination = scanner.next().toUpperCase();

        System.out.print("Ingresa la cantidad a convertir: ");
        double amount = scanner.nextDouble();

        // Llamar a la API para obtener las tasas de cambio
        String response = ApiClient.getExchangeRates(base);

        if (response == null) {
            System.out.println("Error al obtener las tasas de cambio.");
            return;
        }

        // Parsear la respuesta JSON
        ExchangeRate exchangeRate = new ExchangeRateParser().parse(response);

        if (exchangeRate == null) {
            System.out.println("Error al obtener las tasas de cambio.");
            return;
        }

        // Obtener la tasa de conversión
        Double conversionRate = new CurrencyConverter().getConversionRate(exchangeRate, destination);

        if (conversionRate == null) {
            System.out.println("La moneda de destino no está disponible.");
            return;
        }

        // Realizar la conversión y mostrar el resultado
        double result = new CurrencyConverter().convertCurrency(amount, conversionRate);
        new ResultDisplay().displayResult(amount, base, result, destination);

        // Registrar la conversión en el historial
        LocalDateTime timestamp = LocalDateTime.now();
        history.add(new ConversionRecord(base, destination, amount, result, timestamp));
    }

    // Método para mostrar el historial de conversiones
    public static void showConversionHistory() {
        if (history.isEmpty()) {
            System.out.println("No hay conversiones registradas.");
        } else {
            System.out.println("Historial de Conversiones:");
            for (ConversionRecord record : history) {
                System.out.println(record);
            }
        }
    }
}
