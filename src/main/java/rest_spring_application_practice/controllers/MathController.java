package rest_spring_application_practice.controllers;

import org.springframework.web.bind.annotation.*;
import rest_spring_application_practice.service.MathService;


import java.util.ArrayList;


@RestController
@RequestMapping("/math") //Só se usa RequestMapping em topo de classe, em métodos deve-se usar notations especialistas como o GetMapping
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/sum/{n1}/{n2}") //Usando GetMapping pois nao existe alteracao, simples operacao matematica.
    public Double sum(@PathVariable String n1, @PathVariable String n2) {

        return  mathService.sum(n1, n2);
    }

    @GetMapping("/sub/{n1}/{n2}")
    public Double sub(@PathVariable String n1, @PathVariable String n2) {

        return   mathService.sub(n1, n2);
    }

    @GetMapping("/mult/{n1}/{n2}")
    public Double mult(@PathVariable String n1, @PathVariable String n2) {

        return mathService.mult(n1, n2);
    }

    @GetMapping("/div/{n1}/{n2}")
    public Double division(@PathVariable String n1, @PathVariable String n2) {

        return mathService.division(n1, n2);
    }

    @GetMapping("/mean")
    public Double mean(@RequestParam(value = "numbers") ArrayList<String> numbers) {

        return mathService.mean(numbers);
    }

    @GetMapping("/sqrt/{n1}")
    public Double sqrt(@PathVariable String n1) {

        return mathService.sqrt(n1);
    }

}
