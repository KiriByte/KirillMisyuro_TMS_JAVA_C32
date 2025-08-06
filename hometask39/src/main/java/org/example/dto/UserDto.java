package org.example.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "Name cant be a empty")
    private String name;

    @NotBlank(message = "Email cant be a empty")
    @Email(message = "Bad email")
    private String email;

    @NotNull(message = "Age cant be a null")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 50, message = "Age must be at most 50")
    private Integer age;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "Password must containts minimum eight characters, at least one letter, one number and one special character")
    private String password;
}
