package org.example.hometask50.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class AppController {

    @GetMapping()
    public String all() {
        return "all";
    }

    @GetMapping("/auth")
    public String auth() {
        return "authorized";
    }

    @GetMapping("/read")
    public String read() {
        return "read";
    }

    @GetMapping("/support")
    public String support() {
        return "support";
    }

    @GetMapping("/deny")
    public String deny() {
        return "accessDenied";
    }
}
