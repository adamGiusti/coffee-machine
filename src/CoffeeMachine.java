public class CoffeeMachine {
    // Initial resources available
    private int mlWater = 400;
    private int mlMilk = 540;
    private int gramsCoffeeBeans = 120;
    private int numDisposableCups = 9;
    private double moneyAmount = 550;

    // Execution point of coffee machine
    public static void start() {
        greet();
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
    }
}
