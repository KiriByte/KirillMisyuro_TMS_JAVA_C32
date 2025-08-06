package org.example.decorators;

import org.example.model.spell.Spell;

public abstract class SpellDecorator extends Spell {
    protected Spell spell;

    public SpellDecorator(Spell spell) {
        this.spell = spell;
    }

    @Override
    public abstract void cast();
}
