package week05.atm;

import static week05.atm.Denomination.*;

public class AtmExample
{
    public static void main(String[] args)
    {
        MoneyHandler mh500 = new MoneyHandler(FIVE_HUNDRED);
        MoneyHandler mh200 = new MoneyHandler(TWO_HUNDRED);
        MoneyHandler mh100 = new MoneyHandler(ONE_HUNDRED);
        MoneyHandler mh50 = new MoneyHandler(FIFTY);
        MoneyHandler mh10 = new MoneyHandler(TEN);
        MoneyHandler mh5 = new MoneyHandler(FIVE);
        MoneyHandler mh1 = new MoneyHandler(ONE);

        mh500.setNextHandler(mh200)
                .setNextHandler(mh100)
                .setNextHandler(mh50)
                .setNextHandler(mh10)
                .setNextHandler(mh5)
                .setNextHandler(mh1);

        AtmMachine atm = new AtmMachine(mh500);

        atm.withdraw(866);
        atm.withdraw(4500);
        atm.withdraw(1900);
        atm.withdraw(750);

    }
}
