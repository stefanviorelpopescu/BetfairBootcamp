package week03.calculator;

import java.util.Optional;

public class Calculator
{

    public double calculate(String input) {

        CalculationInput calculationInput = parseInput(input);

        double first = calculationInput.getFirst();
        double second = calculationInput.getSecond();

        switch (calculationInput.getOperation()) {
            case PLUS:
                return plus(first, second);
            case MINUS:
                return minus(first, second);
            case TIMES:
                return times(first, second);
            case DIVIDE:
                return dividedBy(first, second);
            default:
                throw new IllegalArgumentException("Invalid operation!");
        }
    }

    private CalculationInput parseInput(String input) //"2 + 3", 3.5 * 6
    {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Invalid input string!");
        }

        Optional<OperationEnum> optionalOperation = OperationEnum.getByOperation(tokens[1]);
        if (!optionalOperation.isPresent()) {
            throw new IllegalArgumentException("Invalid operation string!");
        }

        double first = Double.parseDouble(tokens[0]);
        double second = Double.parseDouble(tokens[2]);

        return new CalculationInput(first, second, optionalOperation.get());
    }

    private double plus(double first, double second) {
        return first + second;
    }

    private double minus(double first, double second) {
        return first - second;
    }

    private double times(double first, double second) {
        return first * second;
    }

    private double dividedBy(double first, double second) {
        return first / second;
    }
}
