package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @GetMapping(path = {"/", ""})
    public String homePage() {
        return "shop/home";
    }

    @PostMapping("/profiles")
    public String profilesPage() {

        return "shop/profiles";
    }

}
