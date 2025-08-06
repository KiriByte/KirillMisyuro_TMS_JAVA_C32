package org.example.hometask43.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private UUID id;

    @NotBlank(message = "{movie.title.notblank}")
    @Size(min = 5, max = 50, message = "{movie.title.size}")
    private String title;
    @Size(max = 500, message = "{movie.description.size}")
    private String description;

}
