package org.tms.classes.service;

import org.tms.classes.model.Cat;
import org.tms.classes.model.Dog;

public class NameExtractorService {

    public String print(Cat cat) {
        return cat.getName();
    }

    public String print(Dog dog) {
        return dog.getName();
    }
}
