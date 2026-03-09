package rest_spring_application_practice.service;

import org.springframework.stereotype.Service;
import rest_spring_application_practice.exception.UnsupportedMathOperationException;
import rest_spring_application_practice.utils.Converter;
import rest_spring_application_practice.utils.NumberUtils;

import java.util.ArrayList;

@Service
public class MathService {

    // As variaveis private final sao parte da injecao de dependencias do Spring junto com o construtor.
    private final Converter converter;
    private final NumberUtils validator;

    public MathService(Converter converter, NumberUtils validator) {
        this.converter = converter;
        this.validator = validator;
    }

    public Double sum(String n1,String n2) {

        if(!validator.isNumeric(n1) || !validator.isNumeric(n2)) {
            throw new UnsupportedMathOperationException("Please enter a numeric value");
        }
        return converter.convertStringToDouble(n1) + converter.convertStringToDouble(n2);
    }

    public Double sub(String n1, String n2) {

        if(!validator.isNumeric(n1) || !validator.isNumeric(n2)) {
            throw new UnsupportedMathOperationException("Please enter a numeric value");
        }

        return converter.convertStringToDouble(n1) - converter.convertStringToDouble(n2);
    }

    public Double mult(String n1, String n2) {

        if(!validator.isNumeric(n1) || !validator.isNumeric(n2)) {
            throw new UnsupportedMathOperationException("Please enter a numeric value");
        }

        return converter.convertStringToDouble(n1) * converter.convertStringToDouble(n2);
    }

    public Double division(String n1, String n2) {
        if(!validator.isNumeric(n1) || !validator.isNumeric(n2)) {
            throw new UnsupportedMathOperationException("Please enter a numeric value");
        }

        Double number1 = converter.convertStringToDouble(n1);
        Double number2 = converter.convertStringToDouble(n2);

        if(number2 == 0D) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return number1 / number2;
    }

    public Double mean(ArrayList<String> numbers) {
        if (numbers == null || numbers.isEmpty()){
            throw new UnsupportedMathOperationException("Provide at least one number");
        }
        return numbers
                .stream()
                .mapToDouble(n -> {
                    if(!validator.isNumeric(n)) {
                        throw new UnsupportedMathOperationException("Please enter a numeric value");
                    }
                    return converter.convertStringToDouble(n);})
                .average()
                .orElse(0.0);
    }

    public Double sqrt(String n1) {
        if(!validator.isNumeric(n1)) {
            throw new UnsupportedMathOperationException("Please enter a numeric value");
        }
        double doubleValue = converter.convertStringToDouble(n1);

        if(doubleValue < 0.0) {
            throw new ArithmeticException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(doubleValue);
    }
}
