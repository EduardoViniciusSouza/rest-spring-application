package rest_spring_application_practice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest_spring_application_practice.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{n1}/{n2}")
    public Double sum(@PathVariable String n1, @PathVariable String n2) {
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsupportedMathOperationException("Please enter a numeric value");

        return convertToDouble(n1) + convertToDouble(n2);
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please enter a numeric value");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
