package org.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Singleton
public class ImmortalDragon {
    private static ImmortalDragon instance;
    private static final Object lock = new Object();
    private final List<String> murderAttempts = new ArrayList<>();
    private boolean isDead = false;

    private ImmortalDragon() {
        System.out.println("«I am the storm that is approaching» — кричит дракон.");
    }

    public static ImmortalDragon getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new ImmortalDragon();
            } else {
                System.out.println("Дракон уже был призван в этот мир!");
            }
            return instance;
        }
    }

    public void tryKill(Person person) {
        synchronized (lock) {
            if (isDead) {
                System.out.println(person.getName() + " бьёт труп дракона. Бесполезно!");
                return;
            }

            murderAttempts.add(person.getName() + " (" + new Date() + ")");
            System.out.println(person.getName() + " убивает дракона! Но ненадолго...");
            isDead = true;
            resurrect();
        }
    }

    private void resurrect() {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                synchronized (lock) {
                    isDead = false;
                    System.out.println("«Forsakened, I am awakened!» — кричит дракон. Всего попыток убить его: " + murderAttempts.size());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public void showMurderHistory() {
        System.out.println("Журнал убийц:");
        for (String attempt : murderAttempts) {
            System.out.println("- " + attempt);
        }
    }
}
