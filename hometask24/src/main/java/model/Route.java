package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    private int id;
    private String description;
    private int lengthInMeters;

    public Route(String description, int lengthInMeters) {
        this.description = description;
        this.lengthInMeters = lengthInMeters;
    }
}
