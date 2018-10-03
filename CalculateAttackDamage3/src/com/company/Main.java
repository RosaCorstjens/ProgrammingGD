// Calculate attack damage

package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // use to randomly generate the pokémons stats
        final int MIN_ATTACK = 40;
        final int MAX_ATTACK = 55;
        final int MIN_HP = 35;
        final int MAX_HP = 50;
        final int MIN_POWER_ATTACK = 35;
        final int MAX_POWER_ATTACK = 45;

        Scanner input = new Scanner(System.in);

        System.out.print("Hello there! You look like a Pokémon trainer... How many Pokémon do you have? ");
        int teamSize = input.nextInt();
        input.nextLine(); // consume new line left over

        String[] names = new String[teamSize];
        String[] attackNames = new String[teamSize];

        double[] powerAttacks = new double[teamSize];
        int[] baseHps = new int[teamSize];
        int[] baseAttacks = new int[teamSize];

        double[] healths = new double[teamSize];
        double[] attacks = new double[teamSize];
        int[] levels = new int[teamSize];

        System.out.println("Wow, that's awesome. Can you tell me a bit more about them?");
        for(int i = 0; i < teamSize; i++){
            System.out.println("Pokemon " + i + ": ");
            System.out.print("Name: ");
            names[i] = input.nextLine();
            System.out.print("Attack name: ");
            attackNames[i] = input.nextLine();
            System.out.print("Level: ");
            levels[i] = input.nextInt();
            input.nextLine(); // consume new line left over

            // randomly generate base stats
            baseHps[i] = Random(MIN_HP, MAX_HP);
            baseAttacks[i] = Random(MIN_ATTACK, MAX_ATTACK);
            powerAttacks[i] = Random((double)MIN_POWER_ATTACK, (double)MAX_POWER_ATTACK);

            // calculate stats based on level
            // (simplified) formula HP: floor(2*base*level/100+level+10)
            // (simplified) formula attack: floor(2*base*level/100+5)
            healths[i] = Math.floor((2 * baseHps[i] * levels[i] / 100f + levels[i] + 10) * 100) / 100;
            attacks[i] = Math.floor((2 * baseAttacks[i] * levels[i] / 100f + 5) * 100) / 100;
        }

        // print all stats
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "\t Level: " + levels[i] + "\t Attack: " + attacks[i] + "\t HP: " + healths[i]);
        }

        // some text to set context
        // choose pokemon to attack with
        double healthCaterpie = 30;
        System.out.println("\nA wild Caterpie appeared! He has " + healthCaterpie + " HP. What Pokémon do you want to use to attack him?");
        for (int i = 0; i < names.length; i++) {
            System.out.println("[" + i + "] " + names[i]);
        }

        int chosenPokemon = input.nextInt();

        // ensure correct input.
        while (chosenPokemon < 0 || chosenPokemon > teamSize - 1) {
            System.out.println("ERROR! This input is not valid...");
            chosenPokemon = input.nextInt();
        }

        // calculate resulting damage and print results
        // formula: (((level / 5 + 2) * power * attack) / 100) + 2
        double resultingDamage = Math.round((((((levels[chosenPokemon] / 20f + 2) * powerAttacks[chosenPokemon] * attacks[chosenPokemon]) / 200) + 2) * 100) / 100);
        healthCaterpie -= resultingDamage;

        System.out.println("\n" + names[chosenPokemon] + " uses " + attackNames[chosenPokemon] + " against Caterpie! \n" +
                names[chosenPokemon] + " deals " + resultingDamage + " damage! \n" +
                "Caterpie is left with " + healthCaterpie + " health.");
    }

    private static double Random(double min, double max){
        return Math.random() * ((max - min) + 1) + min;
    }

    private static int Random(int min, int max){
        return (int)(Math.random() * ((max - min) + 1) + min);
    }
}

