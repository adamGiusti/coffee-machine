import java.util.Scanner;

class Machine {

    private static final Scanner SCANNER = new Scanner(System.in);

    // Machine's resources with initial amounts
    static int mlWater = 800;
    static int mlMilk = 400;
    static int gramsCoffeeBeans = 100;
    static int numDisposableCups = 10;
    static double moneyAmount = 75;

    // Execution point of the machine
    static void start() {
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

        Action.printRemaining();

        System.out.println("Go ahead and interact with me by writing one of the available actions below:");
        System.out.println();
    }

    // Repeatedly request an action from the user until they exit the interaction
    private static void interact() {
        String action;

        do {
            System.out.println("Write action (buy, fill, withdraw, remaining, help, exit):");
            action = SCANNER.next().toLowerCase();
            System.out.println();

            process(action);
        } while (!action.equals("exit"));
    }

    // Interpret the user's chosen action
    private static void process(String action) {
        switch (action) {
            case "buy":
                Action.buy();
                break;
            case "fill":
                Action.fill();
                break;
            case "withdraw":
                Action.withdraw();
                break;
            case "remaining":
                Action.printRemaining();
                break;
            case "help":
                Action.help();
                break;
        }

        System.out.println();
    }
}
