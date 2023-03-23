package week03.calculator;

import lombok.Data;

import java.util.Objects;
import java.util.TreeMap;

@Data
public class CalculationInput
{
    private double first;
    private double second;
    private OperationEnum operation;

    public CalculationInput(double first, double second, OperationEnum operation)
    {
        this.first = first;
        this.second = second;
        this.operation = operation;
    }
}
