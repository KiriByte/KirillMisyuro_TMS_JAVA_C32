package org.example.dto;

import lombok.*;
import org.example.entity.Brand;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class SearchDto {
    private Brand brand;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer minMileage;
    private Integer maxMileage;
    private Integer minYear;
    private Integer maxYear;
}
