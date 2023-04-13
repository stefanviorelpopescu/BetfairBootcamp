package week06.basketball;

import java.util.function.BinaryOperator;

public enum Bonus
{
    JUMP_HEIGHT(Integer::sum),
    SHOE_SIZE(Integer::max),
    ST(Bonus::returnOne),
    DEF(Bonus::returnOne)
    ;

    Bonus(BinaryOperator<Integer> accumulator)
    {
        this.accumulator = accumulator;
    }

    BinaryOperator<Integer> accumulator;

    public BinaryOperator<Integer> getAccumulator()
    {
        return accumulator;
    }

    public static int returnOne(Integer int1, Integer int2) {
        return 1;
    }
}
