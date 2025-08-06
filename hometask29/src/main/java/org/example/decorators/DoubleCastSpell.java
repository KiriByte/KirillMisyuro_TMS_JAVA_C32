package org.example.decorators;

import org.example.model.spell.Spell;

public class DoubleCastSpell extends SpellDecorator {
    public DoubleCastSpell(Spell spell) {
        super(spell);
    }

    @Override
    public void cast() {
        spell.cast();
        spell.cast();
    }
}
