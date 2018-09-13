// Calculate attack damage

package com.company;
import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String NAME_PIKACHU = "Pikachu";
        final String ATTACK_PIKACHU = "Thunder shock";
        final double POWER_ATTACK_PIKACHU = 40;
        final double BASE_HEALTH_PIKACHU = 35;
        final double BASE_ATTACK_PIKACHU = 55;
        double healthPikachu;
        double currentHealthPikachu;
        double attackPikachu;
        int levelPikachu;

        final String NAME_BULBASAUR = "Bulbasaur";
        final String ATTACK_BULBASAUR = "Vine whip";
        final double POWER_ATTACK_BULBASAUR = 45;
        final double BASE_HEALTH_BULBASAUR = 45;
        final double BASE_ATTACK_BULBASAUR = 49;
        double healthBulbasaur;
        double attackBulbasaur;
        int levelBulbasaur;

        final String NAME_SQUIRTLE = "Squirtle";
        final String ATTACK_SQUIRTLE = "Bubble";
        final double POWER_ATTACK_SQUIRTLE = 40;
        final double BASE_HEALTH_SQUIRTLE = 44;
        final double BASE_ATTACK_SQUIRTLE = 48;
        double healthSquirtle;
        double attackSquirtle;
        int levelSquirtle;

        final String NAME_CHARMANDER = "Charmander";
        final String ATTACK_CHARMANDER = "Ember";
        final double POWER_ATTACK_CHARMANER = 40;
        final double BASE_HEALTH_CHARMANDER = 39;
        final double BASE_ATTACK_CHARMANDER = 52;
        double healthCharmander;
        double attackCharmander;
        int levelCharmander;

        final String NAME_PIDGEY = "Pidgey";
        final String ATTACK_PIDGEY = "Quick Attack";
        final double POWER_ATTACK_PIDGEY = 40;
        final double BASE_HEALTH_PIDGEY = 40;
        final double BASE_ATTACK_PIDGEY = 45;
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
        // (simplified) formula HP: floor(floor(2*base)*level/100+level+10)
        // (simplified) formula attack: floor(floor(2*base)*level/100+5)
        healthPikachu = Math.floor(Math.floor(2 * BASE_HEALTH_PIKACHU) * levelPikachu / 100 + levelPikachu + 10);
        attackPikachu = Math.floor(Math.floor(2 * BASE_ATTACK_PIKACHU) * levelPikachu / 100 + 5);

        healthBulbasaur = Math.floor(Math.floor(2 * BASE_HEALTH_BULBASAUR) * levelBulbasaur / 100 + levelBulbasaur + 10);
        attackBulbasaur = Math.floor(Math.floor(2 * BASE_ATTACK_BULBASAUR) * levelBulbasaur / 100 + 5);

        healthSquirtle = Math.floor(Math.floor(2 * BASE_HEALTH_SQUIRTLE) * levelSquirtle / 100 + levelSquirtle + 10);
        attackSquirtle = Math.floor(Math.floor(2 * BASE_ATTACK_SQUIRTLE) * levelSquirtle / 100 + 5);

        healthCharmander = Math.floor(Math.floor(2 * BASE_HEALTH_CHARMANDER) * levelCharmander / 100 + levelCharmander + 10);
        attackCharmander = Math.floor(Math.floor(2 * BASE_ATTACK_CHARMANDER) * levelCharmander / 100 + 5);

        healthPidgey = Math.floor(Math.floor(2 * BASE_HEALTH_PIDGEY) * levelPidgey / 100 + levelPidgey + 10);
        attackPidgey = Math.floor(Math.floor(2 * BASE_ATTACK_PIDGEY) * levelPidgey / 100 + 5);

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
                resultingDamage = (((levelPikachu / 5 + 2) * POWER_ATTACK_PIKACHU * attackPikachu) / 100) + 2;
                healthCaterpie -= resultingDamage;

                System.out.println("\n" + NAME_PIKACHU + "uses " + ATTACK_PIKACHU + " against Caterpie! \n" +
                        NAME_PIKACHU + " deals " + resultingDamage + " damage! \n" +
                        "Caterpie is left with " + healthCaterpie + " health.");
                break;
            case 1:
                resultingDamage = (((levelBulbasaur / 5 + 2) * POWER_ATTACK_BULBASAUR * attackBulbasaur) / 100) + 2;
                healthCaterpie -= resultingDamage;

                System.out.println("\n" + NAME_BULBASAUR + "uses " + ATTACK_BULBASAUR + " against Caterpie! \n" +
                        NAME_BULBASAUR + " deals " + resultingDamage + " damage! \n" +
                        "Caterpie is left with " + healthCaterpie + " health.");
                break;
            case 2:
                resultingDamage = (((levelSquirtle / 5 + 2) * POWER_ATTACK_SQUIRTLE * attackSquirtle) / 100) + 2;
                healthCaterpie -= resultingDamage;

                System.out.println("\n" + NAME_SQUIRTLE + "uses " + ATTACK_SQUIRTLE + " against Caterpie! \n" +
                        NAME_SQUIRTLE + " deals " + resultingDamage + " damage! \n" +
                        "Caterpie is left with " + healthCaterpie + " health.");
                break;
            case 3:
                resultingDamage = (((levelCharmander / 5 + 2) * POWER_ATTACK_CHARMANER * attackCharmander) / 100) + 2;
                healthCaterpie -= resultingDamage;

                System.out.println("\n" + NAME_CHARMANDER + "uses " + ATTACK_CHARMANDER + " against Caterpie! \n" +
                        NAME_CHARMANDER + " deals " + resultingDamage + " damage! \n" +
                        "Caterpie is left with " + healthCaterpie + " health.");
                break;
            case 4:
                resultingDamage = (((levelPidgey / 5 + 2) * POWER_ATTACK_PIDGEY * attackPidgey) / 100) + 2;
                healthCaterpie -= resultingDamage;

                System.out.println("\n" + NAME_PIDGEY + "uses " + ATTACK_PIDGEY + " against Caterpie! \n" +
                        NAME_PIDGEY + " deals " + resultingDamage + " damage! \n" +
                        "Caterpie is left with " + healthCaterpie + " health.");
                break;
        }
    }
}
