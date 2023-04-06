package week05.atm;

public class MoneyHandler
{
    private final Denomination denomination;
    private int stock = 10;

    private MoneyHandler nextHandler;

    public MoneyHandler(Denomination denomination)
    {
        this.denomination = denomination;
    }

    public MoneyHandler setNextHandler(MoneyHandler nextHandler)
    {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public void handle(int amount) {
        int value = denomination.getValue();

        if (amount < value || stock == 0) {
            nextHandler.handle(amount);
            return;
        }

        int count = amount / value;
        if (count > stock) {
            count = stock;
        }

        System.out.println(count + "\tx\t" + value);
        stock -= count;

        int remainingAmount = amount - (count * value);
        if (remainingAmount > 0) {
            if (nextHandler != null) {
                nextHandler.handle(remainingAmount);
            } else {
                throw new RuntimeException("Out of money!");
            }
        }
    }
}
