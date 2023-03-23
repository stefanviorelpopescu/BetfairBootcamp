package week03.calculator;

import java.util.Optional;

public enum OperationEnum
{
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDE("/"),
    ;

    String operation;

    OperationEnum(String operation)
    {
        this.operation = operation;
    }

    public String getOperation()
    {
        return operation;
    }

    public static Optional<OperationEnum> getByOperation(String operation) {
        for (OperationEnum value : OperationEnum.values())
        {
            if (value.getOperation().equals(operation)) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
