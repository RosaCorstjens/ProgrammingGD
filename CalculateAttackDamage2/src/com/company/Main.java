// Calculate attack damage

package com.company;
import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String ATTACK_1_PICKACHU = "Thunder Shock";
        final String ATTACK_2_PICKACHU = "Electro Ball";
        final String ATTACK_3_PICKACHU = "Thunder Wave";
        final String ATTACK_4_PICKACHU = "Spark";

        double powerAttack1Pickachu;
        double powerAttack2Pickachu;
        double powerAttack3Pickachu;
        double powerAttack4Pickachu;

        final double BASE_HEALTH_PICKACHU = 35;
        final double BASE_ATTACK_PICKACHU = 55;
        double healthPickachu;
        double currentHealthPickachu;
        double attackPickachu;
        int levelPickachu;

        final String ATTACK_1_VOLTORB = "Tackle";
        final String ATTACK_2_VOLTORB = "Spark";
        final String ATTACK_3_VOLTORB = "Charge Beam";
        final String ATTACK_4_VOLTORB = "Rollout";

        double powerAttack1Voltorb;
        double powerAttack2Voltorb;
        double powerAttack3Voltorb;
        double powerAttack4Voltorb;

        final double BASE_HEALTH_VOLTORB = 40;
        final double BASE_ATTACK_VOLTORB = 30;
        double healthVoltorb;
        double currentHealthVoltorb;
        double attackVoltorb;
        int levelVoltorb;

        Scanner input = new Scanner(System.in);

        // prompt for level
        System.out.print("Enter Pickachu's level: ");
        levelPickachu = input.nextInt();

        // calculate stats based on level
        // (simplified) formula: floor(floor(2*base)*level/100+5)
        healthPickachu = Math.floor(Math.floor(2 * BASE_HEALTH_PICKACHU) * levelPickachu / 100 + 5);
        currentHealthPickachu = healthPickachu;
        attackPickachu = Math.floor(Math.floor(2 * BASE_ATTACK_PICKACHU) * levelPickachu / 100 + 5);

        System.out.println("Pickachu's stats are: \n"+
                "Health: " + healthPickachu + "\n"+
                "Attack: " + attackPickachu + "\n");

        // prompt for damage per attack
        System.out.println("Enter the power for each of Pickachu's attacks: ");
        System.out.print(ATTACK_1_PICKACHU + ": ");
        powerAttack1Pickachu = input.nextFloat();
        System.out.print(ATTACK_2_PICKACHU + ": ");
        powerAttack2Pickachu = input.nextFloat();
        System.out.print(ATTACK_3_PICKACHU + ": ");
        powerAttack3Pickachu = input.nextFloat();
        System.out.print(ATTACK_4_PICKACHU + ": ");
        powerAttack4Pickachu = input.nextFloat();


        System.out.print("\nEnter Voltorbs level: ");
        levelVoltorb = input.nextInt();

        healthVoltorb = Math.floor(Math.floor(2 * BASE_HEALTH_VOLTORB) * levelVoltorb / 100 + 5);
        currentHealthVoltorb = healthVoltorb;
        attackVoltorb = Math.floor(Math.floor(2 * BASE_ATTACK_VOLTORB) * levelVoltorb / 100 + 5);

        System.out.println("Voltorbs stats are: \n"+
                "Health: " + healthVoltorb + "\n"+
                "Attack: " + attackVoltorb + "\n");

        System.out.println("Enter the power for each of Voltorbs attacks: ");
        System.out.print(ATTACK_1_VOLTORB + ": ");
        powerAttack1Voltorb = input.nextFloat();
        System.out.print(ATTACK_2_VOLTORB + ": ");
        powerAttack2Voltorb = input.nextFloat();
        System.out.print(ATTACK_3_VOLTORB + ": ");
        powerAttack3Voltorb = input.nextFloat();
        System.out.print(ATTACK_4_VOLTORB + ": ");
        powerAttack4Voltorb = input.nextFloat();

        // TODO: pretty print the pokemon info? Should they be obligated to use \t?

        // TODO: what to do if the input is not correct? They can't do a while loop to prompt till correct, right?
        System.out.print("\nWho is attacking? Enter 0 for Pickachu, enter 1 for Voltorb: ");
        int turn = input.nextInt();

        // TODO: we cannot use a terminal operator, can we?
        if(turn == 0)
            System.out.print("What attack is Pickachu using? Enter a number between 0 and 3 to select an attack: ");
        else
            System.out.print("What attack is Voltorb using? Enter a number between 0 and 3 to select an attack: ");

        int chosenAttackInt = input.nextInt();
        String chosenAttackString = "";
        double powerChosenAttack = 0;

        switch(chosenAttackInt){
            case 0:
                if(turn == 0) {
                    chosenAttackString = ATTACK_1_PICKACHU;
                    powerChosenAttack = powerAttack1Pickachu;
                }
                else if(turn == 1){
                    chosenAttackString = ATTACK_1_VOLTORB;
                    powerChosenAttack = powerAttack1Voltorb;
                }
                break;
            case 1:
                if(turn == 0) {
                    chosenAttackString = ATTACK_2_PICKACHU;
                    powerChosenAttack = powerAttack2Pickachu;
                }
                else if(turn == 1){
                    chosenAttackString = ATTACK_2_VOLTORB;
                    powerChosenAttack = powerAttack2Voltorb;
                }
                break;
            case 2:
                if(turn == 0) {
                    chosenAttackString = ATTACK_3_PICKACHU;
                    powerChosenAttack = powerAttack3Pickachu;
                }
                else if(turn == 1){
                    chosenAttackString = ATTACK_3_VOLTORB;
                    powerChosenAttack = powerAttack3Voltorb;
                }
                break;
            case 3:
                if(turn == 0) {
                    chosenAttackString = ATTACK_4_PICKACHU;
                    powerChosenAttack = powerAttack4Pickachu;
                }
                else if(turn == 1){
                    chosenAttackString = ATTACK_4_VOLTORB;
                    powerChosenAttack = powerAttack4Voltorb;
                }
                break;
        }

        // picka
        if(turn == 0){
            // calculate damage
            // formula: ((((2 * level / 5) + 2) * power * attack) / 50) + 2
            double resultingDamage = ((((2 * levelPickachu / 5) + 2) * powerChosenAttack * attackPickachu) / 50) + 2;
            currentHealthVoltorb -= resultingDamage;

            // print results
            System.out.println("Pickachu uses " + chosenAttackString + " against Voltorb! \n" +
                    "Pickachu deals " + resultingDamage + " damage! \n" +
                    "Voltorb is left with " + currentHealthVoltorb + " health.");
        }
        // voltorb
        else if(turn == 1) {
            // calculate damage
            // formula: ((((2 * level / 5) + 2) * power * attack) / 50) + 2
            double resultingDamage = ((((2 * levelVoltorb / 5) + 2) * powerChosenAttack * attackVoltorb) / 50) + 2;
            currentHealthPickachu -= resultingDamage;

            // print results
            System.out.println("Voltorb uses " + chosenAttackString + " against Pickachu! \n" +
                    "Voltorb deals " + resultingDamage + " damage! \n" +
                    "Pickachu is left with " + currentHealthPickachu + " health.");
        }

    }

}
