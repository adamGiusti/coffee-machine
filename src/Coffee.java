public enum Coffee {
    ESPRESSO(250, 0, 16, 4.50),
    LATTE(350, 75, 20, 7.00),
    CAPPUCCINO(200, 100, 12, 6.25);

    // Resources required to make this coffee
    public final String name;
    public final int mlWater;
    public final int mlMilk;
    public final int gramsCoffeeBeans;
    public final double cost;

    Coffee(int mlWater, int mlMilk, int gramsCoffeeBeans, double cost) {
        name = name().toLowerCase();
        this.mlWater = mlWater;
        this.mlMilk = mlMilk;
        this.gramsCoffeeBeans = gramsCoffeeBeans;
        this.cost = cost;
    }
}
