package org.example.model;

import org.example.model.spell.Spell;
import org.example.observer.DragonRessurectionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wizard extends Person implements DragonRessurectionListener {
    private List<Spell> spells = new ArrayList<Spell>();

    public Wizard(String name) {
        super(name);
    }

    public void addSpell(Spell spell) {
        spells.add(spell);
    }

    public void useSpell(int index) {
        if (index >= 0 && index < spells.size()) {
            System.out.print(getName() + " uses ");
            spells.get(index).cast();
        }
    }

    public void useRandomSpell() {
        if (!spells.isEmpty()) {
            Random random = new Random();
            useSpell(random.nextInt(spells.size()));
        }
    }

    @Override
    public void onDragonRessurection(ImmortalDragon dragon) {
        System.out.println(getName() + " sees that the dragon has risen and immediately attacks!");
        useRandomSpell();
        dragon.tryKill(this);
    }
}
