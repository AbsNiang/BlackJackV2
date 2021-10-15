package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {
    static int randomNumberGen() {
        Random random = new Random();
        return random.nextInt(11 - 1) + 1;
    }

    static void loseIfStatement(int userTotal, int compTotal) {
        if ((userTotal > 21) || (compTotal > 21)) {
            if ((userTotal > 21) && (compTotal > 21)) {
                System.out.println("Both you and the computer have a value greater than 21.");
                System.out.println("Nobody wins.");
            } else if (userTotal > 21) {
                System.out.println("You have lost.");
            } else {
                System.out.println("You have won.");
            }
        } else {
            System.out.println("Neither of you have a value over 21");
            if (userTotal == compTotal) {
                System.out.println("You tied with the computer");
            } else if (userTotal > compTotal) {
                System.out.println("You won");
            } else {
                System.out.println("The computer won");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean activeGame;
        do {
            boolean drawOption = true;
            boolean compDrawing = true;
            int compNumTotal = 0;
            int userNumTotal = 0;
            for (int i = 0; i < 2; i++) {
                compNumTotal += randomNumberGen();
            }
            for (int i = 0; i < 2; i++) {
                userNumTotal += randomNumberGen();
            }
            do {
                System.out.println("The value of your current cards is: " + userNumTotal);
                if ((userNumTotal <= 21) && (drawOption)) {
                    System.out.println("Would you like to draw a card or stand? Type 'draw' to draw a card or 'no' to stand");
                    String drawDecision = input.next();
                    if (drawDecision.equalsIgnoreCase("draw") || (drawDecision.equalsIgnoreCase("y")) || (drawDecision.contains("dr"))) {
                        userNumTotal += randomNumberGen();
                        System.out.println("Your value in-hand is now: " + userNumTotal);
                    } else {
                        drawOption = false;
                        System.out.println("You have lost your option to draw cards");
                    }
                }
                if (compNumTotal <= 21) {
                    if (compNumTotal <= 17) {
                        System.out.println("The computer drew a card");
                        compNumTotal += randomNumberGen();
                        System.out.println("The computers value in-hand is: " + compNumTotal);
                    } else {
                        compDrawing = false;
                    }
                }
                if ((!compDrawing) && (!drawOption)) {
                    break;
                }
            } while ((userNumTotal < 21) && (compNumTotal < 21));
            loseIfStatement(userNumTotal, compNumTotal);
            System.out.println("Would you like to play another round?");
            String replayDecision = input.next();
            activeGame = (replayDecision.equalsIgnoreCase("yes")) || (replayDecision.contains("y")) || (replayDecision.contains("Y"));
        } while (activeGame);
        System.out.println("Thank you for playing.");
    }
}