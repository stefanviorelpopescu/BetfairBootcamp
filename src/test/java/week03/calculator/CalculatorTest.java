package week03.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest
{
    private static Calculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @Test
    @Order(1)
    public void whenOnePlusOneThenTwo() {
        //given
        String input = "1 + 1";

        //when
        double result = calculator.calculate(input);

        //then
        assertEquals(2, result, "Result should be 2!");
    }

    @Test
    @Order(2)
    public void whenArgumentsAreEqualAndOperationIsMinusThenResultIsZero() {
        //given
        String operand = "3.6";
        String input = operand + " - " + operand;

        //when
        double result = calculator.calculate(input);

        //then
        assertEquals(0, result, "Result should be 0");
    }

    @Test
    @Order(3)
    public void whenAddingZeroResultIsUnchanged() {
        //given
        double first = 5;
        String input = first + " + 0";

        //when
        double result = calculator.calculate(input);

        //then
        assertEquals(first, result, "Result should be " + first + "!");
    }

    @Test
    @Order(4)
    public void whenSwappingFirstAndSecondResultIsUnchanged() {
        //given
        double first = 5;
        double second = 6;
        String input1 = first + " + " + second;
        String input2 = second + " + " + first;

        //when
        double result1 = calculator.calculate(input1);
        double result2 = calculator.calculate(input2);

        //then
        assertEquals(result1, result2, "Results should be equal!");
    }

    @Test
    public void whenOperationIsInvalidExceptionIsThrown() {
        //given
        String input = "1 h 1";

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input));

        //then
        assertEquals("Invalid operation string!", exception.getMessage());
    }

}