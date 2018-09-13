// Calculate attack damage

package com.company;
import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String NAME_PIKACHU = "Pikachu";
        final String ATTACK_PIKACHU = "Thunder shock";
        final int POWER_ATTACK_PIKACHU = 40;
        final int BASE_HEALTH_PIKACHU = 35;
        final int BASE_ATTACK_PIKACHU = 55;
        double healthPikachu;
        double attackPikachu;
        int levelPikachu;

        final String NAME_BULBASAUR = "Bulbasaur";
        final String ATTACK_BULBASAUR = "Vine whip";
        final int POWER_ATTACK_BULBASAUR = 45;
        final int BASE_HEALTH_BULBASAUR = 45;
        final int BASE_ATTACK_BULBASAUR = 49;
        double healthBulbasaur;
        double attackBulbasaur;
        int levelBulbasaur;

        final String NAME_SQUIRTLE = "Squirtle";
        final String ATTACK_SQUIRTLE = "Bubble";
        final int POWER_ATTACK_SQUIRTLE = 40;
        final int BASE_HEALTH_SQUIRTLE = 44;
        final int BASE_ATTACK_SQUIRTLE = 48;
        double healthSquirtle;
        double attackSquirtle;
        int levelSquirtle;

        final String NAME_CHARMANDER = "Charmander";
        final String ATTACK_CHARMANDER = "Ember";
        final int POWER_ATTACK_CHARMANER = 40;
        final int BASE_HEALTH_CHARMANDER = 39;
        final int BASE_ATTACK_CHARMANDER = 52;
        double healthCharmander;
        double attackCharmander;
        int levelCharmander;

        final String NAME_PIDGEY = "Pidgey";
        final String ATTACK_PIDGEY = "Quick Attack";
        final int POWER_ATTACK_PIDGEY = 40;
        final int BASE_HEALTH_PIDGEY = 40;
        final int BASE_ATTACK_PIDGEY = 45;
        double healthPidgey;
        double attackPidgey;
        int levelPidgey;

        Scanner input = new Scanner(System.in);

        // prompt for levels
        System.out.println("Enter the each Pokémons level: ");

        System.out.print(NAME_PIKACHU + ": ");
        levelPikachu = input.nextInt();

        System.out.print(NAME_BULBASAUR + ": ");
        levelBulbasaur = input.nextInt();

        System.out.print(NAME_SQUIRTLE + ": ");
        levelSquirtle = input.nextInt();

        System.out.print(NAME_CHARMANDER + ": ");
        levelCharmander = input.nextInt();

        System.out.print(NAME_PIDGEY + ": ");
        levelPidgey = input.nextInt();

        // calculate stats based on level
        // (simplified) formula HP: floor(2*base*level/100+level+10)
        // (simplified) formula attack: floor(2*base*level/100+5)
        healthPikachu = Math.floor((2 * BASE_HEALTH_PIKACHU * levelPikachu / 100f + levelPikachu + 10) * 100) / 100;
        attackPikachu = Math.floor((2 * BASE_ATTACK_PIKACHU * levelPikachu / 100f + 5)* 100) / 100;

        healthBulbasaur = Math.floor((2 * BASE_HEALTH_BULBASAUR * levelBulbasaur / 100f + levelBulbasaur + 10) * 100) / 100;
        attackBulbasaur = Math.floor((2 * BASE_ATTACK_BULBASAUR * levelBulbasaur / 100f + 5) * 100) / 100;

        healthSquirtle = Math.floor((2 * BASE_HEALTH_SQUIRTLE * levelSquirtle / 100f + levelSquirtle + 10) * 100) / 100;
        attackSquirtle = Math.floor((2 * BASE_ATTACK_SQUIRTLE * levelSquirtle / 100f + 5) * 100) / 100;

        healthCharmander = Math.floor((2 * BASE_HEALTH_CHARMANDER * levelCharmander / 100f + levelCharmander + 10) * 100) / 100;
        attackCharmander = Math.floor((2 * BASE_ATTACK_CHARMANDER * levelCharmander / 100f + 5) * 100) / 100;

        healthPidgey = Math.floor((2 * BASE_HEALTH_PIDGEY * levelPidgey / 100f + levelPidgey + 10) * 100) / 100;
        attackPidgey = Math.floor((2 * BASE_ATTACK_PIDGEY * levelPidgey / 100f + 5) * 100) / 100;

        // print all stats
        System.out.println("\n" + NAME_PIKACHU + "\t\t Level: " + levelPikachu + "\t Attack: " + attackPikachu + "\t HP: " + healthPikachu + "\n" +
                            NAME_BULBASAUR + "\t Level: " + levelBulbasaur + "\t Attack: " + attackBulbasaur + "\t HP: " + healthBulbasaur + "\n" +
                            NAME_SQUIRTLE + "\t Level: " + levelSquirtle + "\t Attack: " + attackSquirtle + "\t HP: " + healthSquirtle + "\n" +
                            NAME_CHARMANDER + "\t Level: " + levelCharmander + "\t Attack: " + attackCharmander + "\t HP: " + healthCharmander + "\n" +
                            NAME_PIDGEY + "\t\t Level: " + levelPidgey + "\t Attack: " + attackPidgey + "\t HP: " + healthPidgey);

        // some text to set context
        // choose pokemon to attack with
        double healthCaterpie = 30;
        System.out.println("\nA wild Caterpie appeared! He has " + healthCaterpie + " HP. What Pokémon do you want to use to attack him? " + "\n" +
                            "[0] - " + NAME_PIKACHU + "\n" +
                            "[1] - " + NAME_BULBASAUR + "\n" +
                            "[2] - " + NAME_SQUIRTLE + "\n" +
                            "[3] - " + NAME_CHARMANDER + "\n" +
                            "[4] - " + NAME_PIDGEY + "\n");

        int chosenPokemon = input.nextInt();

        // ensure correct input.
        // for the fast students: can you make it so that the program doesn't quit, but prompts again?
        if(chosenPokemon < 0 || chosenPokemon > 4){
            System.out.println("ERROR! This input is not valid...");
            return;
        }

        // calculate resulting damage and print results
        // formula: (((level / 5 + 2) * power * attack) / 100) + 2
        // For fast students: can you define a method which prints the results to which you can pass parameters
        double resultingDamage = 0;
        switch(chosenPokemon){
            case 0:
                resultingDamage = Math.round((((((levelPikachu / 5f + 2) * POWER_ATTACK_PIKACHU * attackPikachu) / 100) + 2) * 100 ) / 100);
                healthCaterpie -= resultingDamage;

                System.out.println("\n" + NAME_PIKACHU + " uses " + ATTACK_PIKACHU + " against Caterpie! \n" +
                        NAME_PIKACHU + " deals " + resultingDamage + " damage! \n" +
                        "Caterpie is left with " + healthCaterpie + " health.");
                break;
            case 1:
                resultingDamage = Math.round((((((levelBulbasaur / 5f + 2) * POWER_ATTACK_BULBASAUR * attackBulbasaur) / 100) + 2) * 100 ) / 100);
                healthCaterpie -= resultingDamage;

                System.out.println("\n" + NAME_BULBASAUR + " uses " + ATTACK_BULBASAUR + " against Caterpie! \n" +
                        NAME_BULBASAUR + " deals " + resultingDamage + " damage! \n" +
                        "Caterpie is left with " + healthCaterpie + " health.");
                break;
            case 2:
                resultingDamage = Math.round((((((levelSquirtle / 5f + 2) * POWER_ATTACK_SQUIRTLE * attackSquirtle) / 100) + 2) * 100 ) / 100);
                healthCaterpie -= resultingDamage;

                System.out.println("\n" + NAME_SQUIRTLE + " uses " + ATTACK_SQUIRTLE + " against Caterpie! \n" +
                        NAME_SQUIRTLE + " deals " + resultingDamage + " damage! \n" +
                        "Caterpie is left with " + healthCaterpie + " health.");
                break;
            case 3:
                resultingDamage = Math.round((((((levelCharmander / 5f + 2) * POWER_ATTACK_CHARMANER * attackCharmander) / 100) + 2) * 100 ) / 100);
                healthCaterpie -= resultingDamage;

                System.out.println("\n" + NAME_CHARMANDER + " uses " + ATTACK_CHARMANDER + " against Caterpie! \n" +
                        NAME_CHARMANDER + " deals " + resultingDamage + " damage! \n" +
                        "Caterpie is left with " + healthCaterpie + " health.");
                break;
            case 4:
                resultingDamage = Math.round((((((levelPidgey / 5f + 2) * POWER_ATTACK_PIDGEY * attackPidgey) / 100) + 2) * 100 ) / 100);
                healthCaterpie -= resultingDamage;

                System.out.println("\n" + NAME_PIDGEY + " uses " + ATTACK_PIDGEY + " against Caterpie! \n" +
                        NAME_PIDGEY + " deals " + resultingDamage + " damage! \n" +
                        "Caterpie is left with " + healthCaterpie + " health.");
                break;
        }
    }
}
