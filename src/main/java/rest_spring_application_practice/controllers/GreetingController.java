package rest_spring_application_practice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest_spring_application_practice.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong(); //mockando id

    // path e querry param = /greeting?name=Eduardo
    @RequestMapping("/greeting") // Jeito legado de fazer, tem alternativas melhores
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "Word")
            String nome) {
        return new Greeting(counter.incrementAndGet(), String.format(template, nome));
    }
}
