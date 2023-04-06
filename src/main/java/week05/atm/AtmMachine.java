package week05.atm;

public class AtmMachine
{
    private final MoneyHandler moneyHandler;

    public AtmMachine(MoneyHandler moneyHandler)
    {
        this.moneyHandler = moneyHandler;
    }

    public void withdraw(int amount) {
        System.out.println("Withdrawing: " + amount);
        moneyHandler.handle(amount);
        System.out.println();
    }
}
