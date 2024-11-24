package Models;

import com.google.gson.Gson;

public class ExchangeRateParser {

    public ExchangeRate parse(String response) {
        Gson gson = new Gson();
        ExchangeRate exchangeRate = gson.fromJson(response, ExchangeRate.class);
        if (exchangeRate != null && exchangeRate.getResult().equals("success")) {
            return exchangeRate;
        }
        return null;
    }
}
