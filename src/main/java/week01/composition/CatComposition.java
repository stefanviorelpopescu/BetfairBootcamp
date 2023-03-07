package week01.composition;

import week01.Animal;

public class CatComposition implements Animal
{
    private PetBasics basics;

    @Override
    public void talk()
    {

    }

    @Override
    public void walk()
    {
        System.out.println(basics.isAdopted());
    }
}
