package org.example.factory;

import org.example.decorators.DoubleCastSpell;
import org.example.decorators.SilentSpell;
import org.example.model.spell.IceSpell;
import org.example.model.spell.Spell;
import org.example.model.Wizard;

public class IceWizardAbstractFactory implements WizardAbstractFactory {
    @Override
    public Wizard createWizard(String name) {
        Wizard wizard = new Wizard(name);
        wizard.addSpell(createSpell());
        wizard.addSpell(createDoubleSpell());
        wizard.addSpell(createSilentSpell());
        return wizard;
    }

    @Override
    public Spell createSpell() {
        return new IceSpell();
    }

    @Override
    public Spell createDoubleSpell() {
        return new DoubleCastSpell(new IceSpell());
    }

    @Override
    public Spell createSilentSpell() {
        return new SilentSpell(new IceSpell());
    }
}
