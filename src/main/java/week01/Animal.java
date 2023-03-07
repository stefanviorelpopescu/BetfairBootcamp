package week01;

public interface Animal
{
    void talk();

    void walk();

    default void sleep() {
        System.out.println("ZZZZZZZZZZZ ...");
    }
}
