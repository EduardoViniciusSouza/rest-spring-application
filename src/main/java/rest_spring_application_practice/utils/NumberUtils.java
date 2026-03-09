package rest_spring_application_practice.utils;

import org.springframework.stereotype.Component;

@Component
public class NumberUtils {

    public boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
