package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    private int id;
    private String description;
    private int lengthInMeters;
    private List<User> userVotes = new ArrayList<>();

    public Route(String description, int lengthInMeters) {
        this.description = description;
        this.lengthInMeters = lengthInMeters;
    }
}
