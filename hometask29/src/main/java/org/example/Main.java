package org.example;

import org.example.model.ImmortalDragon;
import org.example.factory.FireWizardAbstractFactory;
import org.example.factory.IceWizardAbstractFactory;
import org.example.model.Wizard;
import org.example.factory.WizardAbstractFactory;

public class Main {
    public static void main(String[] args) {
        ImmortalDragon dragon = ImmortalDragon.getInstance();
        WizardAbstractFactory fireFactory = new FireWizardAbstractFactory();
        WizardAbstractFactory iceFactory = new IceWizardAbstractFactory();

        Wizard fireWizard = fireFactory.createWizard("Natsu Dragnil");
        Wizard iceWizard = iceFactory.createWizard("Gray Fullbuster");

        dragon.addListener(fireWizard);
        dragon.addListener(iceWizard);

        // Ручная атака для демонстрации
        System.out.println("----------MANUAL ATTACK-----------");
        fireWizard.useRandomSpell();
        dragon.tryKill(fireWizard);
        iceWizard.useSpell(1);
        dragon.tryKill(iceWizard);
        System.out.println("------------------------------------");


        dragon.showMurderHistory();

    }
}