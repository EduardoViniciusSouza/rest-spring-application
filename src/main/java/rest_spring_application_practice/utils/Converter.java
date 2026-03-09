package rest_spring_application_practice.utils;

import org.springframework.stereotype.Component;
import rest_spring_application_practice.exception.UnsupportedMathOperationException;

@Component
public class Converter {

    public Double convertStringToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please enter a numeric value");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
}
