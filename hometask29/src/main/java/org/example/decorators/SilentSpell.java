package org.example.decorators;

import org.example.model.spell.Spell;

public class SilentSpell extends SpellDecorator {
    public SilentSpell(Spell spell) {
        super(spell);
    }

    @Override
    public void cast() {
        System.out.print("(Silent) ");
        spell.cast();
    }
}
