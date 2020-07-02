import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner scanner = new Scanner(System.in);

    // Initial resources available
    private static int mlWater = 500;
    private static int mlMilk = 400;
    private static int gramsCoffeeBeans = 120;
    private static int numDisposableCups = 10;
    private static double moneyAmount = 75;

    // Execution point of coffee machine
    public static void start() {
        greet();
        interact();
    }

    // Introduce the machine to the user
    private static void greet() {
        System.out.println("Greetings! I'm a virtual coffee machine here to serve you.");
        System.out.println();
        System.out.println("I work with typical products: water, milk, coffee beans, and plastic cups; if I run out of something, I'll notify you.");
        System.out.println("You can get three types of coffee: espresso, cappuccino, and latte.");
        System.out.println();

        printRemaining();

        System.out.println("Go ahead and interact with me by writing one of the available actions below:");
        System.out.println();
    }

    // Repeatedly request an action from the user until they exit the interaction
    private static void interact() {
        String action;
        String exitKeyword = "exit";

        do {
            System.out.println("Write action (buy, fill, withdraw, remaining, help, exit):");
            action = scanner.next().toLowerCase();
            System.out.println();

            process(action);
        } while (!action.equals(exitKeyword));
    }

    // Interpret the user's chosen action
    private static void process(String action) {
        switch (action) {
            case "buy":
                initiateBuy();
                break;
            case "fill":
                fill();
                break;
//            case "withdraw":
//                withdraw();
//                break;
            case "remaining":
                printRemaining();
                break;
            case "help":
                help();
                break;
        }
    }

    // Find out what the user wants to buy and execute the transaction
    private static void initiateBuy() {
        String choice;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        choice = scanner.next().toLowerCase();

        if (choice.equals("back")) {
            System.out.println();
            return;
        }

        switch (choice) {
            case "1":
                buy(Coffee.ESPRESSO);
                break;
            case "2":
                buy(Coffee.LATTE);
                break;
            case "3":
                buy(Coffee.CAPPUCCINO);
                break;
        }

        System.out.println();
    }

    // Complete the necessary transaction so long as the machine's resources abide by the specified coffee's requirements
    private static void buy(Coffee coffee) {
        boolean enoughWater = mlWater >= coffee.mlWater;
        boolean enoughMilk = mlMilk >= coffee.mlMilk;
        boolean enoughCoffeeBeans = gramsCoffeeBeans >= coffee.gramsCoffeeBeans;
        boolean enoughDisposableCups = numDisposableCups >= 1;
        boolean enoughResources = enoughWater && enoughMilk && enoughCoffeeBeans && enoughDisposableCups;

        if (enoughResources) {
            System.out.println("One " + coffee.name + " coming right up!");

            numDisposableCups--;
            mlWater -= coffee.mlWater;
            mlMilk -= coffee.mlMilk;
            gramsCoffeeBeans -= coffee.gramsCoffeeBeans;
            moneyAmount += coffee.cost;
        } else {
            printUnavailableResources(coffee, enoughWater, enoughMilk, enoughCoffeeBeans, enoughDisposableCups);
        }
    }

    // Print the resources the machine doesn't have enough of to make the coffee and how much more of them are needed
    private static void printUnavailableResources(Coffee coffee, boolean enoughWater, boolean enoughMilk, boolean enoughCoffeeBeans, boolean enoughDisposableCups) {
        System.out.println("Sorry, but I can't make a(n) " + coffee.name + " without the following resource(s):");

        if (!enoughWater) {
            int mlWaterRequired = coffee.mlWater - mlWater;
            System.out.println("\t" + mlWaterRequired + " more ml of water");
        }
        if (!enoughMilk) {
            int mlMilkRequired = coffee.mlMilk - mlMilk;
            System.out.println("\t" + mlMilkRequired + " more ml of milk");
        }
        if (!enoughCoffeeBeans) {
            int gramsCoffeeBeansRequired = coffee.gramsCoffeeBeans - gramsCoffeeBeans;
            System.out.println("\t" + gramsCoffeeBeansRequired + " more grams of coffee beans");
        }
        if (!enoughDisposableCups) {
            System.out.println("\t1 disposable cup");
        }
    }

    // Restock the machine with a certain amount of each resource
    private static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        mlWater += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        mlMilk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        gramsCoffeeBeans += scanner.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        numDisposableCups += scanner.nextInt();

        System.out.println();
    }

    // Print the remaining resources in the machine
    private static void printRemaining() {
        System.out.println("Here are my current resources:");
        System.out.println("\t" + mlWater + " ml of water");
        System.out.println("\t" + mlMilk + " ml of milk");
        System.out.println("\t" + gramsCoffeeBeans + " grams of coffee beans");
        System.out.println("\t" + numDisposableCups + " disposable cup(s)");
        System.out.println("\t$" + String.format("%.2f", moneyAmount));
        System.out.println();
    }

    // Describe the purpose and use case of each possible action
    private static void help() {
        System.out.println("Here's a list of what each possible action means:");
        System.out.println("\tbuy: Choose between three different types of coffee to buy (cost varies). As long as I have the necessary items, I'll make it for you!");
        System.out.println("\tfill: Add amounts of resources to me to fill me back up.");
        System.out.println("\twithdraw: Collect some of the money I've earned.");
        System.out.println("\tremaining: See how many of the available items I have left.");
        System.out.println("\texit: Stop interacting with me and exit the program.");
        System.out.println();
    }
}
