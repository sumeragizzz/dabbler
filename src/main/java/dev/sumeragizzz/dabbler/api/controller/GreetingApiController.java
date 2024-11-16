package dev.sumeragizzz.dabbler.api.controller;

import dev.sumeragizzz.dabbler.api.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingApiController {

    private static  final String TEMPLATE_MESSAGE = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/api/greeting")
    public Greeting greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), TEMPLATE_MESSAGE.formatted(name));
    }

}
