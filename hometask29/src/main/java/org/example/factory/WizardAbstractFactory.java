package org.example.factory;

import org.example.model.spell.Spell;
import org.example.model.Wizard;

public interface WizardAbstractFactory {
    Wizard createWizard(String name);

    Spell createSpell();

    Spell createDoubleSpell();

    Spell createSilentSpell();
}

