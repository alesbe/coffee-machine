package org.alesbe;

import java.util.Scanner;

public class CoffeeMachine {
    private static int checkAvailableCups(int water, int milk, int coffeeBeans) {
        final int WATER_PER_CUP = 200;
        final int MILK_PER_CUP = 50;
        final int COFFEE_PER_CUP = 15;

        int availableCupsWithWater = water / WATER_PER_CUP;
        int availableCupsWithMilk = milk / MILK_PER_CUP;
        int availableCupsWithCoffee = coffeeBeans / COFFEE_PER_CUP;

        // Return the number of cups that the machine could do with that amount of ingredients
        return Math.min(Math.min(availableCupsWithWater, availableCupsWithMilk), availableCupsWithCoffee);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int water;
        int milk;
        int coffeeBeans;
        int cupsOfCoffee;

        int availableCupsOfCoffee;

        System.out.println("Write how many ml of water the coffee machine has:");
        water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        cupsOfCoffee = scanner.nextInt();

        availableCupsOfCoffee = checkAvailableCups(water, milk, coffeeBeans);

        if(cupsOfCoffee < availableCupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (availableCupsOfCoffee-cupsOfCoffee) + " more than that)");

        } else if (cupsOfCoffee == availableCupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee ");

        } else {
            System.out.println("No, I can make only " + availableCupsOfCoffee + " cup(s) of coffee");

        }
    }
}
