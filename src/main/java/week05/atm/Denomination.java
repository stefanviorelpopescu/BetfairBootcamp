package week05.atm;

public enum Denomination
{
    ONE(1),
    FIVE(5),
    TEN(10),
    FIFTY(50),
    ONE_HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    ;

    Denomination(int i)
    {
        this.value = i;
    }

    int value;

    public int getValue()
    {
        return value;
    }
}
