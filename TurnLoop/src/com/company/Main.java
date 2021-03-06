// Rosa Corstjens
//
// Calculate attack damage
// PvP, turn loops

package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MIN_ATTACK = 40;
        final int MAX_ATTACK = 55;
        final int MIN_HP = 35;
        final int MAX_HP = 50;
        final int MIN_POWER_ATTACK = 35;
        final int MAX_POWER_ATTACK = 45;
        final int MIN_LEVEL = 25;
        final int MAX_LEVEL = 35;

        String nameA, nameB;
        String attackNameA, attackNameB;
        double powerAttackA, powerAttackB;
        int baseHealthA, baseHealthB;
        int baseAttackA, baseAttackB;
        double healthA, healthB;
        double attackA, attackB;
        int levelA, levelB;

        int turn = 0;

        Scanner input = new Scanner(System.in);

        // prompt user to input each 2 pokemon names and their attack names
        System.out.print("Welcome to this Pokémon battle! \nPlayer A, enter the name of your Pokémon: ");
        nameA = input.nextLine();
        System.out.printf("What attack does %s know? ", nameA);
        attackNameA = input.nextLine();
        System.out.printf("Alright, Player A uses %s with %s. \nPress enter to continue.", nameA, attackNameA);

        // wait for enter!
        input.nextLine();

        System.out.print("\nPlayer B, enter the name of your Pokémon: ");
        nameB = input.nextLine();
        System.out.printf("What attack does %s know? ", nameB);
        attackNameB = input.nextLine();
        System.out.printf("And Player B uses %s with %s. \nPress enter to continue.", nameB, attackNameB);

        // wait for enter!
        input.nextLine();

        // randomly generate all base stats and levels
        powerAttackA = Math.random() * ((MAX_POWER_ATTACK - MIN_POWER_ATTACK) + 1) + MIN_POWER_ATTACK;
        powerAttackB = Math.random() * ((MAX_POWER_ATTACK - MIN_POWER_ATTACK) + 1) + MIN_POWER_ATTACK;

        baseHealthA = (int)(Math.random() * ((MAX_HP - MIN_HP) + 1) + MIN_HP);
        baseHealthB = (int)(Math.random() * ((MAX_HP - MIN_HP) + 1) + MIN_HP);

        baseAttackA = (int)(Math.random() * ((MAX_ATTACK - MIN_ATTACK) + 1) + MIN_ATTACK);
        baseAttackB = (int)(Math.random() * ((MAX_ATTACK - MIN_ATTACK) + 1) + MIN_ATTACK);

        levelA = (int)(Math.random() * ((MAX_LEVEL - MIN_LEVEL) + 1) + MIN_LEVEL);
        levelB = (int)(Math.random() * ((MAX_LEVEL - MIN_LEVEL) + 1) + MIN_LEVEL);

        // calculate hp and attack for each, based on generated stats
        // round with 2 decimals
        // (simplified) formula HP: floor(2*base*level/100+level+10)
        // (simplified) formula attack: floor(2*base*level/100+5)
        healthA = Math.floor((2 * baseHealthA * levelA / 100f + levelA + 10) * 100) / 100;
        attackA = Math.floor((2 * baseAttackA * levelA / 100f + 5)* 100) / 100;

        healthB = Math.floor((2 * baseHealthB * levelB / 100f + levelB + 10) * 100) / 100;
        attackB = Math.floor((2 * baseAttackB * levelB / 100f + 5)* 100) / 100;

        // print and format all info about the pokemon
        System.out.println("\n\n... I've observed your Pokémon, and they are all quite strong!");
        System.out.printf("\nPlayer A \nName: %s \tLevel: %d \tAttack: %2.2f \tHP: %2.2f", nameA, levelA, attackA, healthA);
        System.out.printf("\n\nPlayer B \nName: %s \tLevel: %d \tAttack: %2.2f \tHP: %2.2f", nameB, levelB, attackB, healthB);
        System.out.println("\nPress enter to continue.");

        // coin flip for the one to start
        turn = (int)Math.round(Math.random());

        // wait for enter!
        input.nextLine();

        System.out.print("\n\nMay the best Pokemon trainer win!");
        if(turn == 0){
            System.out.println(" Player A may begin.");
        }
        else{
            System.out.println(" Player B may begin.");
        }

        System.out.println("Press enter to continue.");

        //while loop checking whether the trainers pokemon are alive
        Boolean playerAAlive = true;
        Boolean playerBAlive = true;
        double damage = 0;
        while(playerAAlive && playerBAlive){
            if(turn == 0){
                damage = Math.round((((((levelA / 20f + 2) * powerAttackA * attackA) / 200) + 2) * 100 ) / 100);
                healthB -= damage;

                System.out.printf("\n%s uses %s against %s and deals %3.2f damage!", nameA, attackNameA, nameB, damage);
                System.out.printf("\n%s is left with %2.2f HP.", nameB, healthB);

                if(healthB <= 0)
                    playerBAlive = false;

                turn = 1;
            }
            else{
                damage = Math.round((((((levelB / 20f + 2) * powerAttackB * attackB) / 200) + 2) * 100 ) / 100);
                healthA -= damage;

                System.out.printf("\n%s uses %s against %s and deals %3.2f damage!", nameB, attackNameB, nameA, damage);
                System.out.printf("\n%s is left with %2.2f HP.", nameA, healthA);

                if(healthA <= 0)
                    playerAAlive = false;

                turn = 0;
            }

            // wait for enter!
            System.out.println("\nPress enter to continue.");
            input.nextLine();
        }

        // win message
        if(playerAAlive){
            System.out.println("\n\nPlayer A won!");
        }
        else if(playerBAlive){
            System.out.println("\n\nPlayer B won!");
        }
        else{
            System.out.println("Seems to be a tie... ");
        }
    }
}
