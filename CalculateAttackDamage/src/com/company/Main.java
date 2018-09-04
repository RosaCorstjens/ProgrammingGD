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

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Pickachu's base damage: ");
        baseDamagePickachu = input.nextFloat();

        System.out.print("Enter how effective Pickachu's attack is in percent: ");
        effectiveProcentPickachu = input.nextInt();

        resultingDamagePickachu = ((baseDamagePickachu / 100) * effectiveProcentPickachu);
        currentHealth = MAX_HEALTH - resultingDamagePickachu;
        System.out.println("The other pokemon starts with " + MAX_HEALTH + " health.\n" +
                "Pickachu deals " + resultingDamagePickachu + " damage.\n"+
                "The other pokemon is left with " + currentHealth + " health.");
    }
}
