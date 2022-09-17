package org.alesbe;

import java.util.Scanner;

public class CoffeeMachine {
    // Coffee types constants
    final int ESPRESSO_WATER = 250;
    final int ESPRESSO_COFFEE = 16;
    final int ESPRESSO_PRICE = 4;

    final int LATTE_WATER = 350;
    final int LATTE_MILK = 75;
    final int LATTE_COFFEE = 20;
    final int LATTE_PRICE = 7;

    final int CAPPUCCINO_WATER = 200;
    final int CAPPUCCINO_MILK = 100;
    final int CAPPUCCINO_COFFEE = 12;
    final int CAPPUCCINO_PRICE = 6;

    // Available resources
    int availableWater = 400;
    int availableMilk = 540;
    int availableCoffee = 120;
    int availableCups = 9;
    int availableMoney = 550;

    // Actions
    private void buy() {
        Scanner scanner = new Scanner(System.in);
        String option;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        option = scanner.next();

        switch (option) {
            case "1":
                if(availableWater < ESPRESSO_WATER) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if(availableCoffee < ESPRESSO_COFFEE) {
                    System.out.println("Sorry, not enough coffee!");
                    return;
                }

                this.availableWater -= ESPRESSO_WATER;
                this.availableCoffee -= ESPRESSO_COFFEE;
                this.availableMoney += ESPRESSO_PRICE;
                this.availableCups--;
                break;

            case "2":
                if(availableWater < LATTE_WATER) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if(availableMilk < LATTE_MILK) {
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                if(availableCoffee < LATTE_COFFEE) {
                    System.out.println("Sorry, not enough coffee!");
                    return;
                }

                this.availableWater -= LATTE_WATER;
                this.availableMilk -= LATTE_MILK;
                this.availableCoffee -= LATTE_COFFEE;
                this.availableMoney += LATTE_PRICE;
                this.availableCups--;
                break;

            case "3":
                if(availableWater < CAPPUCCINO_WATER) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if(availableMilk < CAPPUCCINO_MILK) {
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                if(availableCoffee < CAPPUCCINO_COFFEE) {
                    System.out.println("Sorry, not enough coffee!");
                    return;
                }

                this.availableWater -= CAPPUCCINO_WATER;
                this.availableMilk -= CAPPUCCINO_MILK;
                this.availableCoffee -= CAPPUCCINO_COFFEE;
                this.availableMoney += CAPPUCCINO_PRICE;
                this.availableCups--;
                break;

            case "back":
                break;

            default:
                System.out.println("Please, enter a valid option.");
                break;
        }
    }

    private void fill() {
        Scanner scanner = new Scanner(System.in);

        int auxOption;
        System.out.println("Write how many ml of water you want to add:");
        auxOption = scanner.nextInt();
        this.availableWater += auxOption;

        System.out.println("Write how many ml of milk you want to add:");
        auxOption = scanner.nextInt();
        this.availableMilk += auxOption;

        System.out.println("Write how many grams of coffee beans you want to add:");
        auxOption = scanner.nextInt();
        this.availableCoffee += auxOption;

        System.out.println("Write how many disposable cups you want to add:");
        auxOption = scanner.nextInt();
        this.availableCups += auxOption;
    }

    private void take() {
        System.out.println("I gave you $" + this.availableMoney);
        System.out.println();
        this.availableMoney = 0;
    }

    private void displayInfo() {
        System.out.println("The coffee machine has:");
        System.out.println(this.availableWater + " ml of water");
        System.out.println(this.availableMilk + " ml of milk");
        System.out.println(this.availableCoffee + " g of coffee beans");
        System.out.println(this.availableCups + " disposable cups");
        System.out.println("$" + this.availableMoney + " of money");
        System.out.println();
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        String action;

        mainLoop: while(true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.next();

            switch (action) {
                case "buy":
                    coffeeMachine.buy();
                    break;

                case "fill":
                    coffeeMachine.fill();
                    break;

                case "take":
                    coffeeMachine.take();
                    break;

                case "remaining":
                    coffeeMachine.displayInfo();
                    break;

                case "exit":
                    break mainLoop;

                default:
                    System.out.println("Enter a valid option!");
                    break;
            }
        }
    }
}
