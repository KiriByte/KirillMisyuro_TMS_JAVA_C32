package org.example.controller;

import org.example.UserRegisterDto;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
public class RegistrationController {

    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final int MIN_USERNAME_LENGTH = 3;

    private final MessageSource messageSource;

    public RegistrationController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserRegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, UserRegisterDto user, Locale locale) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException(messageSource.getMessage("error.username.empty", null, locale));
        }

        if (user.getUsername().length() < MIN_USERNAME_LENGTH) {
            throw new IllegalArgumentException(messageSource.getMessage("error.username.length", new Object[]{MIN_USERNAME_LENGTH}, locale));
        }

        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new IllegalArgumentException(messageSource.getMessage("error.password.length", new Object[]{MIN_PASSWORD_LENGTH}, locale));
        }

        if (Math.random() < 0.3) {
            throw new RuntimeException(messageSource.getMessage("error.server", null, locale));
        }

        model.addAttribute("message", messageSource.getMessage("register.success", null, locale));
        return "success";
    }

}
