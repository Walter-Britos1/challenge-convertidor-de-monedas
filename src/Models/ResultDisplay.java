package Models;

import java.text.DecimalFormat;

public class ResultDisplay {

    public void displayResult(double amount, String base, double result, String destination) {
        DecimalFormat format = new DecimalFormat("#.##");
        System.out.println(format.format(amount) + " " + base + " es igual a " + format.format(result) + " " + destination);
    }
}
