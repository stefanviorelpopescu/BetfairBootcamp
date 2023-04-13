package week06;

import java.util.Optional;

public class Label
{
    private final String labelName;

    public Label(String labelName)
    {
        this.labelName = labelName;
    }

    public Optional<String> getOptionalName() {
        return Optional.of(this.labelName);
    }
}
