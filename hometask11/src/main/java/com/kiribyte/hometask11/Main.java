package com.kiribyte.hometask11;

import com.kiribyte.hometask11.exception.WrongLoginException;
import com.kiribyte.hometask11.exception.WrongPasswordException;
import com.kiribyte.hometask11.service.UserRegisterService;

public class Main {
    public static void main(String[] args) {
        var login = "Username";
        var password = "ConfirmPassword1";
        var confirmPassword = "ConfirmPassword1";

        try {
            UserRegisterService.register(login, password, confirmPassword);
            System.out.println("User successfully registered!");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}