enum Coffee {

    ESPRESSO(250, 0, 16, 4.50),
    LATTE(350, 75, 20, 7.00),
    CAPPUCCINO(200, 100, 12, 6.25);

    // Resources required to make this coffee
    final String NAME;
    final int ML_WATER;
    final int ML_MILK;
    final int GRAMS_COFFEE_BEANS;
    final double COST;

    private Coffee(int mlWater, int mlMilk, int gramsCoffeeBeans, double cost) {
        NAME = name().toLowerCase();
        this.ML_WATER = mlWater;
        this.ML_MILK = mlMilk;
        this.GRAMS_COFFEE_BEANS = gramsCoffeeBeans;
        this.COST = cost;
    }
}
