package org.example.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private String login;
    private String name;
    private int age;

}
