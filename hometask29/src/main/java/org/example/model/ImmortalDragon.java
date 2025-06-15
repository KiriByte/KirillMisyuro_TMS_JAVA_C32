package org.example.model;

import org.example.observer.DragonRessurectionListener;
import org.example.observer.DragonRessurectionSubject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//Singleton
public class ImmortalDragon implements DragonRessurectionSubject {
    private static ImmortalDragon instance;
    private static final Object lock = new Object();
    private final List<String> murderAttempts = new ArrayList<>();
    private boolean isDead = false;
    private List<DragonRessurectionListener> listeners = new ArrayList<>();

    private ImmortalDragon() {
        System.out.println("«I am the storm that is approaching» — crying dragon!.");
    }

    public boolean getIsDead() {
        synchronized (lock) {
            return isDead;
        }
    }

    public static ImmortalDragon getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new ImmortalDragon();
            } else {
                System.out.println("The dragon had already been summoned to this world!");
            }
            return instance;
        }
    }

    public void tryKill(Person person) {
        synchronized (lock) {
            if (isDead) {
                System.out.println(person.getName() + " strikes the dragon's body. It's useless!");
                return;
            }

            Random random = new Random();
            double chance = random.nextDouble();

            if (chance < 0.3) {
                murderAttempts.add(person.getName() + " (" + new Date() + ")");
                System.out.println(person.getName() + " kills the dragon! But not for long....");
                isDead = true;
                resurrect();
            } else {
                System.out.println("It didn't work out... Try again another time.");
            }
        }
    }

    private void resurrect() {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(3000) + 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        isDead = false;
        System.out.println("«Forsakened, I am awakened!» — crying dragon. Total kill attempts: " + murderAttempts.size());

        // Уведомляем всех слушателей
        notifyRessurection();
    }

    public void showMurderHistory() {
        System.out.println("Killers journal:");
        for (String attempt : murderAttempts) {
            System.out.println("- " + attempt);
        }
    }

    @Override
    public void addListener(DragonRessurectionListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(DragonRessurectionListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void notifyRessurection() {
        System.out.println("Notifying all observers about dragon resurrection...");
        for (DragonRessurectionListener listener : listeners) {
            listener.onDragonRessurection(this);
        }
    }
}
