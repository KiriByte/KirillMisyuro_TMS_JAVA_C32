package org.example.observer;

import java.util.Observer;

public interface DragonRessurectionSubject {
    void addListener(DragonRessurectionListener listener);

    void removeListener(DragonRessurectionListener listener);

    void notifyRessurection();
}
