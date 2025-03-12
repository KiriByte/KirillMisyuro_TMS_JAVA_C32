package com.kiribyte.hometask11;

import com.kiribyte.hometask11.exception.WrongLoginException;
import com.kiribyte.hometask11.exception.WrongPasswordException;
import com.kiribyte.hometask11.service.UserRegisterService;

public class Main {
    public static void main(String[] args) {
        var login = "Username";
        var password = "Password1111111111111111111111111";
        var confirmPassword = "Confirm Password";

        try {
            UserRegisterService.register(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}