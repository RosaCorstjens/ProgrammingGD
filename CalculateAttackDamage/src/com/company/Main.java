// Calculate attack damage
// Calculates the attack damage of Pickachu for a given attack

package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO: do they learn floats or doubles? Both?
        float baseDamagePickachu;
        int effectiveProcentPickachu;
        float resultingDamagePickachu;

        final int MAX_HEALTH = 100;
        float currentHealth = MAX_HEALTH;

        int totalAmountOfAttacks;
        float totalAmountOfDamage;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Pickachu's base damage: ");
        baseDamagePickachu = input.nextFloat();

        System.out.print("Enter how effective Pickachu's attack is in percent: ");
        effectiveProcentPickachu = input.nextInt();

        resultingDamagePickachu = ((baseDamagePickachu / 100) * effectiveProcentPickachu);
        currentHealth = MAX_HEALTH - resultingDamagePickachu;
        System.out.println("\nThe other pokemon starts with " + MAX_HEALTH + " health.\n" +
                "Pickachu deals " + resultingDamagePickachu + " damage.\n"+
                "The other pokemon is left with " + currentHealth + " health.");

        totalAmountOfAttacks = (int)Math.ceil(MAX_HEALTH / resultingDamagePickachu);
        totalAmountOfDamage = totalAmountOfAttacks * resultingDamagePickachu;

        System.out.println("\nPickachu would need to attack " + totalAmountOfAttacks + " times to defeat the other pokemon.\n"+
                "Pickachu would then deal " + totalAmountOfDamage + " damage.");
    }
}
