package week01.inheritance;

public class Cat extends Pet
{
    private int livesLeft;

    public int getLivesLeft()
    {
        System.out.println(isAdopted());
        return livesLeft;
    }
}
