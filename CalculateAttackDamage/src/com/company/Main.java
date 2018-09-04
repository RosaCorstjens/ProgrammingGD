// Calculate attack damage
// Calculates the attack damage of Pickachu for a given attack

package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float baseDamagePickachu;
        int effectiveProcentPickachu;
        float resultingDamagePickachu;

        final int maxHealth = 100;
        float currentHealth = maxHealth;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Pickachu's base damage: ");
        baseDamagePickachu = input.nextFloat();

        System.out.print("Enter effective Pickachu's attack is in percent: ");
        effectiveProcentPickachu = input.nextInt();

        resultingDamagePickachu = ((baseDamagePickachu / 100) * effectiveProcentPickachu);
        currentHealth = maxHealth - resultingDamagePickachu;
        System.out.println("Pickachu deals " + resultingDamagePickachu + " damage.\n"+
                "The other pokemon is left with " + currentHealth + " health.");
    }
}
