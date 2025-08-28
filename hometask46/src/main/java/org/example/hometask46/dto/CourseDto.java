package org.example.hometask46.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
    private UUID id;
    private String name;
    private int days;
    private BigDecimal price;
    private boolean isActive;

}
