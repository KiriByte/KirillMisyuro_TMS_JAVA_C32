package org.example;

import net.datafaker.Faker;
import org.example.model.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Faker faker = new Faker();

        Map<String, User> userMap = new HashMap<>();
        for (var i = 0; i < 10; i++) {
            var user = new User(faker.internet().username(), faker.name().firstName(), new Random().nextInt(95));
            userMap.put(user.getName(), user);
        }
        System.out.println(userMap);

        //--------------------------------------

        String[] words = new String[10];
        for (int i = 0; i < words.length; i++) {
            words[i] = faker.word().noun();
        }

        Map<String, Integer> wordLengthMap = new HashMap<>();
        for (var word : words) {
            wordLengthMap.put(word, word.length());
        }
        System.out.println(wordLengthMap);
    }
}