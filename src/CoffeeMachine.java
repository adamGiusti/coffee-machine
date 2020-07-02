import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner scanner = new Scanner(System.in);

    // Initial resources available
    private static int mlWater = 400;
    private static int mlMilk = 540;
    private static int gramsCoffeeBeans = 120;
    private static int numDisposableCups = 9;
    private static double moneyAmount = 550;

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
        System.out.println("Go ahead and interact with me by writing one of the available actions below:");
        System.out.println();

        printRemaining();
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

    // Interpret the user's specified action
    private static void process(String action) {
        switch (action) {
//            case "buy":
//                buy();
//                break;
//            case "fill":
//                fill();
//                break;
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

    // Print the remaining resources in the machine
    private static void printRemaining() {
        System.out.println("Here are my available resources:");
        System.out.println(mlWater + " ml of water");
        System.out.println(mlMilk + " ml of milk");
        System.out.println(gramsCoffeeBeans + " grams of coffee beans");
        System.out.println(numDisposableCups + " disposable cup(s)");
        System.out.println("$" + String.format("%.2f", moneyAmount));
        System.out.println();
    }

    // Describe the purpose and use case of each possible action
    private static void help() {
        System.out.println("Here's a list of what each possible action means:");
        System.out.println("buy: Choose between three different types of coffee to buy (cost varies). As long as I have the necessary items, I'll make it for you!");
        System.out.println("fill: Add amounts of resources to me to fill me back up.");
        System.out.println("withdraw: Collect some of the money I've earned.");
        System.out.println("remaining: See how many of the available items I have left.");
        System.out.println("exit: Stop interacting with me and exit the program.");
        System.out.println();
    }
}
