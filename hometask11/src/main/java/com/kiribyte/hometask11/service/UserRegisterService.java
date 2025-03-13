package com.kiribyte.hometask11.service;

import com.kiribyte.hometask11.exception.WrongLoginException;
import com.kiribyte.hometask11.exception.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegisterService {

    private static final String passwordPattern = "^(?=.*\\d)(?!.*\\s).{1,19}$";
    private static final Pattern pattern = Pattern.compile(passwordPattern);

    public static void register(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (isNullOrEmpty(login)) {
            throw new WrongLoginException("Login is null or empty");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Login is too long");
        }
        if (login.contains(" ")) {
            throw new WrongLoginException("Login contains spaces");
        }


        if (isNullOrEmpty(password)) {
            throw new WrongPasswordException("Password is null or empty");
        }
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new WrongPasswordException("Password must contain at least one digit and no spaces");
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Password does not match");
        }

    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
