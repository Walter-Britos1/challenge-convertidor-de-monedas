package Models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
 private static String API_URL = "https://v6.exchangerate-api.com/v6/";
        private static String API_KEY= "2587cf893a6531ce1625d066";
    
        public static String getExchangeRates(String baseCurrency) {
            String url = API_URL + API_KEY + "/latest/" + baseCurrency;

        try {
            // Configurar cliente HTTP
            HttpClient client  = HttpClient.newHttpClient();

            // Crear la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
            
            // Realizar la solicitud
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Devolver el cuerpo de la respuesta
            return response.body();

        } catch (Exception e) {
            System.out.println("Error al obtener las tasas de cambio de monedas: " + e.getMessage());
            return null;
        }
    }

};
