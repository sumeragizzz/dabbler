package dev.sumeragizzz.dabbler.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {

    @GetMapping("/")
    public String initialize() {
        return "index";
    }

}
