package Models;

public class CurrencyConverter {

    public Double getConversionRate(ExchangeRate exchangeRate, String destination) {
        return exchangeRate.getConversion_rates().get(destination);
    }

    public double convertCurrency(double amount, Double conversionRate) {
        return amount * conversionRate;
    }
}
