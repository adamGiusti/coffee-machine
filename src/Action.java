import java.util.Scanner;

class Action {

    private static final Scanner SCANNER = new Scanner(System.in);

    // Print the remaining resources in the machine
    static void printRemaining() {
        System.out.println("Here are my current resources:");
        System.out.println("\t" + Machine.mlWater + " ml of water");
        System.out.println("\t" + Machine.mlMilk + " ml of milk");
        System.out.println("\t" + Machine.gramsCoffeeBeans + " grams of coffee beans");
        System.out.println("\t" + Machine.numDisposableCups + " disposable cup(s)");
        System.out.println("\t$" + moneyFormat(Machine.moneyAmount));
    }

    // Find out what the user wants to buy and execute the transaction
    static void buy() {
        String choice;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        choice = SCANNER.next().toLowerCase();

        if (choice.equals("back")) {
            return;
        }

        switch (choice) {
            case "1":
                executeTransaction(Coffee.ESPRESSO);
                break;
            case "2":
                executeTransaction(Coffee.LATTE);
                break;
            case "3":
                executeTransaction(Coffee.CAPPUCCINO);
                break;
        }
    }

    // Complete the necessary transaction so long as the machine's resources abide by the specified coffee's requirements
    private static void executeTransaction(Coffee coffee) {
        boolean enoughWater = Machine.mlWater >= coffee.ML_WATER;
        boolean enoughMilk = Machine.mlMilk >= coffee.ML_MILK;
        boolean enoughCoffeeBeans = Machine.gramsCoffeeBeans >= coffee.GRAMS_COFFEE_BEANS;
        boolean enoughDisposableCups = Machine.numDisposableCups >= 1;
        boolean enoughResources = enoughWater && enoughMilk && enoughCoffeeBeans && enoughDisposableCups;

        if (enoughResources) {
            System.out.println("One " + coffee.NAME + " coming right up!");

            Machine.numDisposableCups--;
            Machine.mlWater -= coffee.ML_WATER;
            Machine.mlMilk -= coffee.ML_MILK;
            Machine.gramsCoffeeBeans -= coffee.GRAMS_COFFEE_BEANS;
            Machine.moneyAmount += coffee.COST;
        } else {
            printUnavailableResources(coffee, enoughWater, enoughMilk, enoughCoffeeBeans, enoughDisposableCups);
        }
    }

    // Print the resources the machine doesn't have enough of to make the coffee and how much more of them are needed
    private static void printUnavailableResources(Coffee coffee, boolean enoughWater, boolean enoughMilk, boolean enoughCoffeeBeans, boolean enoughDisposableCups) {
        System.out.println("Sorry, but I can't make a(n) " + coffee.NAME + " without the following resource(s):");

        if (!enoughWater) {
            int mlWaterRequired = coffee.ML_WATER - Machine.mlWater;
            System.out.println("\t" + mlWaterRequired + " more ml of water");
        }
        if (!enoughMilk) {
            int mlMilkRequired = coffee.ML_MILK - Machine.mlMilk;
            System.out.println("\t" + mlMilkRequired + " more ml of milk");
        }
        if (!enoughCoffeeBeans) {
            int gramsCoffeeBeansRequired = coffee.GRAMS_COFFEE_BEANS - Machine.gramsCoffeeBeans;
            System.out.println("\t" + gramsCoffeeBeansRequired + " more grams of coffee beans");
        }
        if (!enoughDisposableCups) {
            System.out.println("\t1 disposable cup");
        }
    }

    // Restock the machine with a certain amount of each resource
    static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        Machine.mlWater += SCANNER.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        Machine.mlMilk += SCANNER.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        Machine.gramsCoffeeBeans += SCANNER.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        Machine.numDisposableCups += SCANNER.nextInt();

        System.out.println("Update complete!");
        System.out.println();
        printRemaining();
    }

    // Take away a given amount of money from the machine
    static void withdraw() {
        double moneyAmountWithdrawn;

        System.out.println("How much money do you want to collect?");
        moneyAmountWithdrawn = SCANNER.nextDouble();

        if (Machine.moneyAmount >= moneyAmountWithdrawn) {
            Machine.moneyAmount -= moneyAmountWithdrawn;

            System.out.println("$" + moneyFormat(moneyAmountWithdrawn) + " has been withdrawn.");
            System.out.println("I now have $" + moneyFormat(Machine.moneyAmount) + " left.");
        }
    }

    // Describe the purpose and use case of each possible action
    static void help() {
        System.out.println("Here's a list of all the possible actions:");
        System.out.println("\tbuy: Choose between three different types of coffee to buy (cost varies). As long as I have the necessary items, I'll make it for you!");
        System.out.println("\tfill: Add amounts of resources to me to fill me back up.");
        System.out.println("\twithdraw: Collect some of the money I've earned.");
        System.out.println("\tremaining: See how many of the available items I have left.");
        System.out.println("\texit: Stop interacting with me and exit the program.");
    }

    // Return double value as a string with two decimal places
    private static String moneyFormat(double moneyAmount) {
        return String.format("%.2f", moneyAmount);
    }
}
