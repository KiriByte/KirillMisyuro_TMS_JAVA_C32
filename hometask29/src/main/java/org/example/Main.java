package org.example;

import org.example.model.ImmortalDragon;
import org.example.model.Person;

public class Main {
    public static void main(String[] args) {
        ImmortalDragon dragon = ImmortalDragon.getInstance();
        Person wizard = new Person("Гэндальф") {
        };

        try {
            //ждем 1 секунду и пробуем убить мертвого дракона
            Thread.sleep(1000);
            dragon.tryKill(wizard);


            // Ждем еще 2.5 секунды (всего 3.5 секунды) (уже должен жить)
            Thread.sleep(2500);
            dragon.tryKill(wizard);

            //Пробуем призвать еще дракона
            dragon = ImmortalDragon.getInstance();
            dragon.showMurderHistory();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}