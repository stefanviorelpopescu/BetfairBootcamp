package week05.chainOfResponsability;

import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.Objects.nonNull;

public class Chain implements MessageHandler
{
    private final Predicate<String> canHandle;
    private final Consumer<String> currentHandler;
    private Chain nextChain;

    public Chain(Predicate<String> canHandle, Consumer<String> currentHandler)
    {
        this.canHandle = canHandle;
        this.currentHandler = currentHandler;
    }

    public Chain setNext(Chain nextChain) {
        this.nextChain = nextChain;
        return nextChain;
    }

    @Override
    public void handle(String message)
    {
        if (canHandle.test(message)) {
            currentHandler.accept(message);
        }
        else if (nonNull(nextChain)) {
            nextChain.handle(message);
        } else {
            throw new RuntimeException("handler not found");
        }
    }
}
