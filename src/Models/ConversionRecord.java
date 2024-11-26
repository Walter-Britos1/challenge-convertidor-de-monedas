package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversionRecord {
    private String base; // Moneda base
    private String targetCurrency; // Moneda de destino
    private double convertedAmount; // Cantidad convertida
    private double conversionResult; // Resultado de la conversión
    private LocalDateTime timestamp; // Fecha y hora de la conversión

    // Contructor para la clase ConversionRecord
    public ConversionRecord(
            String base,
            String targetCurrency,
            double convertedAmount,
            double conversionResult,
            LocalDateTime timestamp
        ) {
        this.base = base;
        this.targetCurrency = targetCurrency;
        this.convertedAmount = convertedAmount;
        this.conversionResult = conversionResult;
        this.timestamp = timestamp;
    }

    // Getters y Setters
    public String getbase() {
        return base;
    }

    public void setbase(String base) {
        this.base = base;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(double conversionResult) {
        this.conversionResult = conversionResult;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Formatear el texto para mostrar la información de la conversion
    @Override
    public String toString() {
        // Formatear la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String formatedDate = formatter.format(timestamp);

        return String.format(
            "%s -> %s | Cantidad: %.2f | Resultado: %.2f | Fecha: %s",
            base,
            targetCurrency,
            convertedAmount,
            conversionResult,
            formatedDate
        );
    }
}
