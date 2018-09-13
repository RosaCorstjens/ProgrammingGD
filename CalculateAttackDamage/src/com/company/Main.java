// Calculate attack damage
// Calculates the attack damage of Pickachu for a given attack

package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float basisDamagePickachu;
        int effectivititeitProcentPickachu;
        float resulterendeDamagePickachu;

        final int TOTALE_HP = 100;
        float actueleHP = TOTALE_HP;

        int totaalAantalAttacks;
        float totaalAantalDamage;

        Scanner input = new Scanner(System.in);

        System.out.print("Pickachu's basis damage: ");
        basisDamagePickachu = input.nextFloat();

        System.out.print("Effectiviteit van Pickachu's attack in procent: ");
        effectivititeitProcentPickachu = input.nextInt();

        resulterendeDamagePickachu = ((basisDamagePickachu / 100) * effectivititeitProcentPickachu);
        actueleHP = TOTALE_HP - resulterendeDamagePickachu;
        System.out.println("\nDe andere Pokémon start met " + TOTALE_HP + " HP.\n" +
                "Pickachu doet " + resulterendeDamagePickachu + " damage.\n"+
                "De andere Pokémon houdt " + actueleHP + " HP over.");

        totaalAantalAttacks = (int)Math.ceil(TOTALE_HP / resulterendeDamagePickachu);
        totaalAantalDamage = totaalAantalAttacks * resulterendeDamagePickachu;

        System.out.println("\nPickachu moet " + totaalAantalAttacks + " keer aanvallen om de andere Pokémon te verslaan.\n"+
                "Pickachu zou dan in totaal " + totaalAantalDamage + " damage doen.");
    }
}
